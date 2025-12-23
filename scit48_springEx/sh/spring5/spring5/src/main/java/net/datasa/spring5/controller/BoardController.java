package net.datasa.spring5.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring5.domain.dto.BoardDTO;
import net.datasa.spring5.domain.dto.ReplyDTO;
import net.datasa.spring5.service.BoardService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 게시판 관련 컨트롤러
 */
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
    private final BoardService bs;
	
	

    // application.properties 파일의 설정값.
    @Value("${board.pageSize}")
    int pageSize;

    @Value("${board.linkSize}")
    int linkSize;

    @Value("${board.uploadPath}")
    String uploadPath;

    /**
     * 글쓰기 페이지로 이동
     * 
     * @return writeForm.html
     */

    @GetMapping("write")
    public String write() {
        return "boardView/writeForm";
    }

    /**
     * 글 저장
     * 
     * @param boardDTO 작성한 글 정보
     * @param user     로그인한 사용자 정보
     * @param upload   첨부파일
     * @return 게시판 글 목록 경로
     */
    @PreAuthorize("isAuthenticated()")
    @PostMapping("write")
    public String write(BoardDTO boardDTO,
            @AuthenticationPrincipal UserDetails user,
            @RequestParam(name = "upload", required = false) MultipartFile upload) {

        // 작성한 글 정보에 사용자 아이디 추가
        boardDTO.setMemberId(user.getUsername());
        log.debug("저장할 글 정보 : {}", boardDTO);

        // 업로드된 첨부파일
        if (upload != null) {
            log.debug("Empty : {}", upload.isEmpty());
            log.debug("파라미터 이름 : {}", upload.getName());
            log.debug("파일명 : {}", upload.getOriginalFilename());
            log.debug("파일크기 : {}", upload.getSize());
            log.debug("파일종류 : {}", upload.getContentType());
        }

        try {
            bs.write(boardDTO, uploadPath, upload);
        } catch (Exception e) {
            log.debug("예외 발생 {}", e.getMessage());
            return "boardView/writeForm";
        }

        return "redirect:/"; // 임시
    }

    @GetMapping("listAll")
    public String listAll(Model model) {
        List<BoardDTO> dtoList = bs.getListAll();

        model.addAttribute("listAll", dtoList);

        return "boardView/listAll";
    }
	
	
	@GetMapping("read")
	public String read(@RequestParam("boardNum") int boardNum, Model model){
		log.debug("조회할 글번호 {}",boardNum);
		
		
		try {
			BoardDTO boardDTO = bs.getBoard(boardNum);
			model.addAttribute("board", boardDTO);
			List<ReplyDTO> replydto = bs.getReply(boardNum);
			model.addAttribute("reply", replydto);
//
			
			

			
			
			return "boardView/read";
			
		}catch (Exception e){
			return "redirect:/board/list";
		}
		

		
		
	}
	@GetMapping("download")
	public void download(@RequestParam("boardNum") int boardNum, HttpServletResponse response){
		bs.download(boardNum, response, uploadPath);
	}
	
	@GetMapping("like")
	public String like(int boardNum){
		log.debug("추천할 번호 {}", boardNum);
		
		bs.like(boardNum);
		
		
		return String.format("redirect:/board/read?boardNum=" +boardNum);
	}
	@GetMapping("preview")
	public ResponseEntity<Resource> preview(@RequestParam("boardNum") int boardNum)
		throws Exception {
		/*
			ResponseEntity<T> htto  응답 전체 (상태 + 헤더 +바디)를 자바 객체로 표현
			ResponseEntity<Resource> : HTTP 응답의 바디로 "읽을 수 있는 데이터"를 보내겠다는 의미
			MIME(Multipurpose Internet Mail Extentions)
			- 이 데이터가 어떤종류이 데이터인지 설명하는 표준 문자ㅕㄹ
			MIME 타입			의미
			text/html			HTML 문서
			text/plain			일반 텍스트
			application/json	json 데이터
			image/jpeg			jpeg 이미지
			application/octet-stream	알 수 없는 바이너리 데이터
		 */
		BoardDTO board = bs.getBoard(boardNum);
		
		Path path = Paths.get(uploadPath, board.getFileName());
		if(!Files.exists(path)){
			return ResponseEntity.notFound().build();
		}
		
		String contentType = Files.probeContentType(path);
		if (contentType == null) contentType = "application/octet-stream";
		
		if(!contentType.startsWith("image/")){
			return ResponseEntity.status(415).build();
		}
		Resource resource = new FileSystemResource(path);
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION
						,"inline; filename=\""
						+ URLEncoder.encode(board.getOriginalName()
						, StandardCharsets.UTF_8) + "\""
				).body(resource);
				
	}
	@PreAuthorize("isAuthenticated()")
	@GetMapping("delete")
	public String delete(@RequestParam("boardNum") int boardNum
			, @AuthenticationPrincipal UserDetails user){
		log.debug("delete의 첫관문 {}",boardNum);
		
		try {
			bs.delete(boardNum, user.getUsername(), uploadPath);
		} catch (Exception e) {
			log.debug("[예외 발생] {}", e.getMessage());
			return "redirect:/board/read?boardNum=" + boardNum;
		}
		
		return "redirect:/board/listAll";
	}
	
	/**
	 *
	 * @param boardNum
	 * @param user
	 * @param model
	 * @return updateForm.html
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping("update")
	public String updateForm(@RequestParam("boardNum") int boardNum
			, @AuthenticationPrincipal UserDetails user
			, Model model){
		log.debug("update의 첫관문 {}",boardNum);
		
		
		try {
			BoardDTO boardDTO = bs.getBoard(boardNum);
			if (!user.getUsername().equals(boardDTO.getMemberId())){
				throw new RuntimeException("수정 권한이 없습니다.");
			}
			model.addAttribute("board",boardDTO);
			return "boardView/updateForm";
		} catch (Exception e) {
			log.debug("[예외 발생] {}", e.getMessage());
			return "redirect:/";
		}
		
		
	}
	
	/**
	 * 게시글 수정 처리
	 * @param boardDTO
	 * @param user
	 * @param upload
	 * @return
	 */
	@PostMapping("update")
	public String update(BoardDTO boardDTO, @AuthenticationPrincipal UserDetails user
						, MultipartFile upload){
		try {
			bs.update(boardDTO, user.getUsername(), uploadPath, upload);
			return "redirect:read?boardNum=" + boardDTO.getBoardNum();
		} catch (Exception e){
			log.debug("[예외 발상] {}", e.getMessage());
			return "redirect:/";
		}
	}
	
	/**
	 *  게시판 목록을 조회하고 페이징및검색기능을 제공
	 * @param model			html에 저장하기 위한객체
	 * @param page			현재 페이지
	 * @param searchType	검색 대상
	 * @param searchWord	검색어
	 * @return
	 */
	@GetMapping("list")
	public String list(
			Model model
			, @RequestParam(name = "page", defaultValue = "1") int page
			, @RequestParam(name = "searchType", defaultValue = "") String searchType
			, @RequestParam(name = "searchWord", defaultValue = "") String searchWord
	){
		log.debug("설정 값 : pageSize={} linkSize={}", pageSize, linkSize);
		log.debug("요청 파라미터 : page={}, searchType={}, searchWord={}",
				page, searchType, searchWord);
		
		/**
		 * 	Page<T>
		 * 	    조회된 데이터 목록 + 페이징메타정보를 함께 담고 있는 객체
		 * 	    List<T>처럼데이터를 담고 있으면서도, 페이짖ㅇ 관련 정보를  함꼐 제공함
		 *		메서드			설명
		 *		getContent()	실제 데이터 리스트 변환(List<T>)
		 *		getTotalElements 전체 항목 수
		 *		getTotalPage()	전체 페이지 수
		 *		getNumber		현제 페이지 변호 (0부터 시작)
		 *		hasNext(), isFirst() 등 	페이징 네비게이션에 활용 가능
		 * */
		Page<BoardDTO> boardpage =
				bs.getlist(page, pageSize, searchType, searchWord);
		
		model.addAttribute("boardPage", boardpage);
		model.addAttribute("page", page);
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchWord",searchWord);
		model.addAttribute("linkSize", linkSize);
		
		log.debug("전체 개수: {}", boardpage.getTotalElements());
		log.debug("전체 페이지 수: {}", boardpage.getTotalElements());
		log.debug("현재 페이지: {}", boardpage.getNumber());
		log.debug("페이지당 글 수: {}",boardpage.getSize());
		log.debug("이전페이지 존재: {}",boardpage.hasPrevious());
		log.debug("다음 페이지 존재: {}",boardpage.hasNext());
		
		return "boardView/list";
	}
	
	/**
	 *
	 * @param dto
	 * @param user
	 * @return
	 */
	@PostMapping("replyWrite")
	public String replyForm(ReplyDTO dto
			, @AuthenticationPrincipal UserDetails user){
		
		dto.setMemberId(user.getUsername());
		
		try {
			bs.replyWrite(dto);
		}catch (Exception e){
			log.debug("[예외 발생] {}", e.getMessage());
		}
		
		return "redirect:/board/read?boardNum=" + dto.getBoardNum();
	}
	@GetMapping("replyDelete")
	public String replyDelete(
			ReplyDTO replyDTO,
			@AuthenticationPrincipal UserDetails user
	){
		try{
			bs.replyDelete(replyDTO.getReplyNum(), user.getUsername());
		} catch (Exception e){
			log.debug("[예외 발생] {}",  e.getMessage());
		}
		return "redirect:/board/read?boardNum=" + replyDTO.getBoardNum();
	}
	@GetMapping("replyUpdate")
	public String replyUpdate(
			ReplyDTO replyDTO,
			@AuthenticationPrincipal UserDetails user
			){
		try{
			bs.replyUpdate(replyDTO, user.getUsername());
		} catch (Exception e){
			log.debug("[예외 발생] {}", e.getMessage());
		}
		
		return "redirect:/board/read?boardNum=" + replyDTO.getBoardNum();
	}
	@GetMapping("replyList")
	public  String replyList(@RequestParam("replyId") String replyId, Model model){
		log.debug("리플 목록{}",replyId);
		List<ReplyDTO> reply = bs.getReplyList(replyId);
		model.addAttribute("reply", reply);
		model.addAttribute("memberId", replyId);
		
//
		return "/boardView/reply";
	}
}
