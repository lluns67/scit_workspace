package net.datasa.ex2.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.ex2.domain.dto.StudentDTO;
import net.datasa.ex2.domain.entity.StudentEntity;
import net.datasa.ex2.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class StudentService {
	private final StudentRepository sr;
	
	public List<StudentDTO> selectAll() {
		List<StudentEntity> entityList = sr.findAll();
		List<StudentDTO> dtoList = new ArrayList<>();
		log.debug(entityList.toString());
		
		for(StudentEntity entity : entityList){
			StudentDTO dto = new StudentDTO();
			dto.setSid(entity.getStudentId());
			dto.setName(entity.getName());
			dto.setMajor(entity.getMajor());
			dto.setJava(entity.getJava());
			dto.setDb(entity.getDb());
			dto.setWeb(entity.getWeb());
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	public void insert(StudentDTO dto) {
		StudentEntity entity = new StudentEntity();
		
		entity.setName(dto.getName());
		entity.setMajor(dto.getMajor());
		entity.setJava(dto.getJava());
		entity.setDb(dto.getDb());
		entity.setWeb(dto.getWeb());
		
		sr.save(entity);
		
		
	}
	
	public StudentDTO select(String sid) {
		StudentEntity entity = sr.findById(sid)
				.orElseThrow(()->
						new EntityNotFoundException("회원이 없다?"));
		
		StudentDTO dto = new StudentDTO();
		dto.setSid(entity.getStudentId());
		dto.setName(entity.getName());
		dto.setMajor(entity.getMajor());
		dto.setJava(entity.getJava());
		dto.setDb(entity.getDb());
		dto.setWeb(entity.getWeb());
		
		return dto;
	}
	
	public void delete(String sid) {
		StudentEntity entity = sr.findById(sid).orElseThrow(()->new EntityNotFoundException("에러"));
		sr.delete(entity);
	}
}
