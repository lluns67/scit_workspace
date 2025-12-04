package net.datasa.spring4.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring4.domain.dto.GuestBookDTO;
import net.datasa.spring4.domain.entity.GuestBookEntity;
import net.datasa.spring4.domain.entity.GuestBookRecommendEntity;
import net.datasa.spring4.domain.entity.GuestBookRecommendKey;
import net.datasa.spring4.repository.GuestBookRecommendRepository;
import net.datasa.spring4.repository.GuestBookRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor  // 파이널로 선언하는 거라고 함
public class GuestBookService {
	
	private final GuestBookRepository gr;
	private final GuestBookRecommendRepository grr;
	
	public void test() {
		
		GuestBookEntity entity = GuestBookEntity.builder()
				// num 은 auto_increment에 의해서 생성
				.name("작성자")
				.password("111")
				.message("글저장 테스트 중")
				//inputdate는 Auditing에 의해서 생성
				.build();
		
		gr.save(entity);
	}
	
	public void write(GuestBookDTO dto) {
		if(dto.getName().length() > 100){
			dto.setName(dto.getName().substring(0,100));
		}
		if(dto.getPassword().length() > 100){
			dto.setPassword(dto.getPassword().substring(0,100));
		}
		
		GuestBookEntity entity = GuestBookEntity.builder()
				.name(dto.getName())
				.password(dto.getPassword())
				.message(dto.getMessage())
				.recommendCnt(0)
				.build();
		
		gr.save(entity);
	}
	
	public List<GuestBookDTO> getList() {
		
		List<Person> list = new ArrayList<>();
		list.add(new Person("홍길동", 30));
		list.add(new Person("강감찬", 80));
		list.add(new Person("이순신", 45));
		
		Collections.sort(list, new PersonNameComparator());
		list.sort((p1,p2)->p1.name().compareTo(p2.name()));
		list.stream().forEach(l->log.debug("> {}",l));
		
		/*
		 *	spring Data JPA - Sort 객체
		 * 	데이터 조회시 정렬을 손쉽게 적용할 수 있도록 해주는 유틸리티 클래스
		 * 	Sort.Order : "정렬 조건 하나"를 객체로 표현한 것.
		 * 				Java 객체로 사용하므로써 IDE 자동완성 및 컴파일 체크 가능
		 *
		 * enum
		 * 		- 미리 정의된 고정된 값들의 목록을 나태내는 자료형(상수 집합)
		 */
		Sort sort = Sort.by(Sort.Direction.DESC,  "inputdate");
		
		Sort sort2 = Sort.by(
				Sort.Order.desc("name").ignoreCase(),
				Sort.Order.asc("num"),
				Sort.Order.desc("inputdate")
		);
		
		List <GuestBookEntity> entityList  = gr.findAll();
		List <GuestBookDTO> dtoList = new ArrayList<>();
		for(GuestBookEntity entity : entityList){
			GuestBookDTO dto = GuestBookDTO.builder()
					.num(entity.getNum())
					.name(entity.getName())
					.message(entity.getMessage())
					.inputdate(entity.getInputdate())
					.recommendCnt(entity.getRecommendCnt())
					.build();
			dtoList.add(dto);
		}
		
		
		return dtoList;
	}
	
	public void delete(Integer num, String pw) {
		
		GuestBookEntity entity = gr.findById(num).orElseThrow(()->new EntityNotFoundException("없음"));
		if(!entity.getPassword().equals(pw)){
			throw new RuntimeException("비밀번호가 틀립니다.");
		}
			gr.deleteById(num);
	}
	
//	public GuestBookDTO update(Integer num, String password) {
//		GuestBookEntity entity = gr.findById(num).orElseThrow(()-> new EntityNotFoundException("없음"));
//		if(!entity.getPassword().equals(password)){
//			throw new RuntimeException("비밀번호가 틀립니다.");
//		} else {
//			GuestBookDTO dto = GuestBookDTO.builder()
//					.num(entity.getNum())
//					.name(entity.getName())
//					.message(entity.getMessage())
//					.inputdate(entity.getInputdate())
//					.build();
//			return dto;
//		}
		
		
//	}
	
	public void passwordCheck(Integer num, String password) {
		GuestBookEntity entity = gr.findById(num)
				.orElseThrow( ()-> new EntityNotFoundException(num + "번 글이 없습니다."));
		if (!entity.getPassword().equals(password)){
			throw new RuntimeException("비밀번호가 틀립니다.");
		}
	}
	/*
		게시글 정보 조회
	 */
	public GuestBookDTO selectGuestbook(Integer num) {
		GuestBookEntity entity = gr.findById(num)
				.orElseThrow( ()-> new EntityNotFoundException(num + "번 글이 없습니다."));
		GuestBookDTO dto = GuestBookDTO.builder()
				.num(entity.getNum())
				.name(entity.getName())
				.password(entity.getPassword())
				.message(entity.getMessage())
				.inputdate(entity.getInputdate()).build();
		return dto;
	}
	
	public void update(GuestBookDTO dto) {
		GuestBookEntity entity = gr.findById(dto.getNum())
				.orElseThrow(()->
						new EntityNotFoundException(dto.getNum() + "번 글이 없습니다."));
		
		entity.setPassword(dto.getPassword());
		entity.setMessage(dto.getMessage());
	}
	
	public void recommend(Integer num, String ip) {
		GuestBookRecommendKey key = new GuestBookRecommendKey(num, ip);
		
		boolean exists = grr.existsById(key);
		if(exists){
			throw new RuntimeException("이미 추천한 글입니다.");
		}
		GuestBookRecommendEntity recommend =
				GuestBookRecommendEntity.builder()
						.id(key).build();
		grr.save(recommend);
	GuestBookEntity guest = gr.findById(num).orElseThrow(
			()->new RuntimeException("글을 찯을 수 없습니다."));
		guest.increaserRecommend();
	}
	

}

record Person(String name, int age){}

class PersonNameComparator implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2){
		return o1.name().compareTo(o2.name());
	}
}