package net.nocori.spring21.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("impl1")
@Slf4j
public class TestServiceImpl1 implements TestService {
	
	
	@Override
	public void testLog() {
	
	}
}
