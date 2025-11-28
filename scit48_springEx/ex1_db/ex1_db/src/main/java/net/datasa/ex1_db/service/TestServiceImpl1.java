package net.datasa.ex1_db.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("impl1")
public class TestServiceImpl1 implements TestService{
	@Override
	public void testlog() {
		log.debug("1번");
	}
}
