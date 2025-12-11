package net.datasa.spring5.service;


import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring5.domain.dto.MemberDTO;
import net.datasa.spring5.domain.entity.MemberEntity;
import net.datasa.spring5.repository.MemberRepository;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
	회원정보 서비스
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {
	
	// 암호화 인코더
	private final BCryptPasswordEncoder passwordEncoder;
	
	// 회원 관련 Repository
	private final MemberRepository mr;
	
	// 저장 테스트
	public void test() {
		MemberEntity entity = MemberEntity.builder()
				.memberid("aaa")
				.memberPassword(passwordEncoder.encode("111"))
				.memberName("홍길동")
				.email("aaa@aaa.com")
				.phone("010-1111-2222")
				.address("서울시 강남구 삼성동 코엑스")
				.enabled(true)
				.rolename("ROLE_USER")
				.build();
		mr.save(entity);
	}
	
	public void join(MemberDTO dto) {
		
		MemberEntity entity = MemberEntity.builder()
				.memberid(dto.getMemberId())
				.memberPassword(passwordEncoder.encode(dto.getMemberPassword()))
				.memberName(dto.getMemberName())
				.email(dto.getEmail())
				.phone(dto.getPhone())
				.address(dto.getAddress())
				.enabled(dto.getEnabled())
				.rolename(dto.getRolename())
				.build();
		mr.save(entity);
	}
	
	/**
	 * 가입시 아이디 중복 확인
	 * @param searchId
	 * @return 해당 아이디로 가입 가능 여부
	 */
	public boolean idCheck(String searchId) {
		return !mr.existsById(searchId);
	}
	
	/**
	 * 회원목록을 조회
	 * @return 회원목록
	 */
	public List<MemberDTO> selectAll() {
		
		Sort sort = Sort.by(
					Sort.Order.asc("rolename"),
					Sort.Order.desc("memberName")
		);
		List<MemberEntity> entityList = mr.findAll(sort);
		List<MemberDTO>		dtoList	= new ArrayList<>();
		
		for (MemberEntity entity: entityList){
			MemberDTO dto = MemberDTO.builder()
					.memberId(entity.getMemberid())
					.memberName(entity.getMemberName())
					
					.email(entity.getEmail())
					.phone(entity.getPhone())
					.address(entity.getAddress())
					.enabled(entity.getEnabled())
					.rolename(entity.getRolename()).build();
			dtoList.add(dto);
		}
		return  dtoList;
	}
	
	/**
	 * 권한 변경
	 * @param memberId
	 */
	@PreAuthorize("hasRole('ADMIN')")
	public void update(String memberId) {
		MemberEntity entity = mr.findById(memberId).orElseThrow(()-> new EntityNotFoundException("회원이 존재하지 않습니다."));
	String updateRolename =entity.getRolename().equals("ROLE_USER") ? "ROLE_ADMIN" : "ROLE_USER";
		entity.setRolename(updateRolename);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void enabled(String id, boolean enabled) {
		MemberEntity entity = mr.findById(id).orElseThrow(()->new EntityNotFoundException("회원이 존재하지 않습니다."));
		
		entity.setEnabled(enabled);
	}
	
	/**
	 * 휴먼 계정 해제 처리
	 * @param memberId
	 * @param memberPassword
	 */
	public void inactive(String memberId, String memberPassword) {
		MemberEntity entity = mr.findById(memberId)
				.orElseThrow(
						()->new EntityNotFoundException("회원이 존재하지 않습니다.")
				);
		if (!passwordEncoder.matches(memberPassword, entity.getMemberPassword())){
			throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
		}
		entity.setEnabled(true);
	}
}
