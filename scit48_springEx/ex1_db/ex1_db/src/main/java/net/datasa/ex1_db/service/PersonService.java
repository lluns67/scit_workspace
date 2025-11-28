package net.datasa.ex1_db.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.ex1_db.domain.dto.PersonDTO;
import net.datasa.ex1_db.domain.entity.PersonEntity;
import net.datasa.ex1_db.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
// 커밋해주고 이거저거 해줌
@Transactional

//생성자 자동
@RequiredArgsConstructor

public class PersonService {
	private final PersonRepository pr;
	
	public void test(){
		PersonEntity entity = new PersonEntity();
		entity.setId("럭키짱");
		entity.setName("강건마");
		entity.setAge(18);
		
		pr.save(entity);
	}
	
	public void insert(PersonDTO dto) {
		PersonEntity entity = new PersonEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		
		log.debug(entity.toString());
		pr.save(entity);
	}
}
