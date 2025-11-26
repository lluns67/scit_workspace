package net.nocori.spring21.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nocori.spring21.domain.dto.PersonDTO;
import net.nocori.spring21.domain.entity.PersonEntity;
import net.nocori.spring21.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {
	private final PersonRepository pr;
	
	public void test(){
		PersonEntity entity = new PersonEntity();
		entity.setId("aaa");
		entity.setName("김아무개");
		entity.setAge(31);
		
		pr.save(entity);
	}
	
	public void insert(PersonDTO personDTO) {
		PersonEntity personEntity = new PersonEntity();
		
		personEntity.setId(personDTO.getId());
		personEntity.setName(personDTO.getName());
		personEntity.setAge(personDTO.getAge());
		
		pr.save(personEntity);
	}
	
	
	public PersonDTO select(String id) {
		PersonEntity entity = pr.findById(id).orElseThrow(() ->
				new RuntimeException("회원이 존재하지 않습니다."));
		
		if (entity == null) return null;
		PersonDTO dto = new PersonDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setAge(entity.getAge());
		return dto;
	}
	
	public void delete(String id) {
		PersonEntity entity = pr.findById(id).orElseThrow(() ->
				new RuntimeException("회원이 존재하지 않습ㄴ다."));
		pr.delete(entity);
		
	}
	
	public List<PersonDTO> selectAll() {
		List<PersonEntity> entityList= pr.findAll();
		List<PersonDTO> personDTOS = new ArrayList<>();
		log.debug(entityList.toString());
		
		for( PersonEntity entity : entityList ){
			PersonDTO personDTO = new PersonDTO();
			personDTO.setId(entity.getId());
			personDTO.setName(entity.getName());
			personDTO.setAge(entity.getAge());
			personDTOS.add(personDTO);
		}
		return personDTOS;
	}
}
