package net.datasa.spring3.service;


import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring3.domain.dto.PersonDTO;
import net.datasa.spring3.domain.entity.PersonEntity;
import net.datasa.spring3.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
// 메서드나 클래스에 적용하면, 해당 메서도가 호출될 떄 트랜잭션이 시작되고,
// 정상적으로 메서드의 실행이 완료되면 트랜잭션 Commit,
// 예외가발생하면 트랜잭션 Rollback
@Transactional
// 클래스 안의 final 필드를 자동으로 생성자에 넣어줌
@RequiredArgsConstructor
public class PersonService {
	private final PersonRepository pr;
	
	/*
			JpaRepository 기본 제공하는 메서드
				메서드			설명ㅇ
				save(entity)	Insert or Update
				findById(id)	ID 기준 조회
				findAll()		전체조회
				delete(entity)	엔티티삭제
				deleteById(id)	ID 기준 삭제
				count()			전체 개수 조회
	 */
	
	public void test() {
		
		PersonEntity entity = new PersonEntity();
		entity.setId("aaaaa");
		entity.setName("김아무개");
		entity.setAge(30);
		
		// JPA 가 제공하는 기본 메서드
		pr.save(entity);
	}
	
	public void insert(PersonDTO dto) {
		
		PersonEntity entity = new PersonEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		
		pr.save(entity);
	}
	
	public PersonDTO select(String id) {
		/*
			Optional<T>는
			null 값으로 인한 NullPointerException을 방지하기 위한 자바 클래스
			"값이 있을 수도, 없을 수도 있다"는 것으로 명시적으로 표현하며,
			값이 없을 경우에 처리하는 방식을 메서드로 제공.
			
		 */
		PersonEntity entity = pr.findById(id)
				.orElseThrow(() ->
						new EntityNotFoundException("회원이 존재하지 않습니다."));
		
		if (entity == null){
			return null;
		}
		PersonDTO dto = new PersonDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setAge(entity.getAge());
		
		return dto;
	}
	/*
		id에 일치하는 사람 1명 삭제
		@param id
	 */
	public void delete(String id) {
//		pr.deleteById(id);
		
		PersonEntity entity = pr.findById(id)
			
				.orElseThrow(
				()  ->	new EntityNotFoundException("외원이 존재하지 않습니다")
				);
		
		pr.delete(entity);
	}
	
	/*
		 모든 사용자 정보 조회
		 @return 사용자 정보가 담긴 객체들의 리스트
	 */
	
	public List<PersonDTO> selectAll() {
		List<PersonEntity> entityList = pr.findAll();
		List<PersonDTO> dtoList = new ArrayList<>();
		log.debug(entityList.toString());
		for(PersonEntity entity : entityList){
			PersonDTO dto = new PersonDTO();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setAge(entity.getAge());
			dtoList.add(dto);
		}
		
		return dtoList;
	}
	/*
		사용자 정보 수정
	 */
	public void update(PersonDTO dto) {
		PersonEntity entity = pr.findById(dto.getId())
				.orElseThrow(
						()-> new EntityNotFoundException("회원이 존재하지 않습니다."));
		log.debug("수정 전: {}",entity);
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		
		log.debug("수정 후: {}", entity);
		pr.save(entity);
	}
}