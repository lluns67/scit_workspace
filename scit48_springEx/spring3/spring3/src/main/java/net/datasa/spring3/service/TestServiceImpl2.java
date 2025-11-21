package net.datasa.spring3.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("impl2")
public class TestServiceImpl2 implements TestService{
	
	@Override
	public void testLog() {
		log.debug("2번 서비스 로직 실행");
	}
}
