package net.datasa.spring5.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring5.domain.dto.MemberDTO;
import net.datasa.spring5.domain.entity.MemberEntity;
import net.datasa.spring5.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
}
