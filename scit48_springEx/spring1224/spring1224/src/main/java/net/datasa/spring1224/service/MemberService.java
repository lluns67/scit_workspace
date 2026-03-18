package net.datasa.spring1224.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring1224.domain.Entity.MemberEntity;
import net.datasa.spring1224.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {
	
//	private final BCryptPasswordEncoder passwordEncoder;
	
	private final MemberRepository mr;
	
	public void test() {
		MemberEntity entity = MemberEntity.builder()
				.memberId("test")
				.memberPassword("111")
				.memberName("홍길동")
				.email("aaa@aaa.vc")
				.phone("010-1234-5678")
				.address("경기도 고양시 일산서구")
				.enabled(true)
				.rolename("ROLE_USER").build();
		mr.save(entity);
	}
}
