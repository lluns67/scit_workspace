package net.datasa.spring6.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import net.datasa.spring6.Repository.CommentRepository;
import net.datasa.spring6.domain.dto.CommentDTO;
import net.datasa.spring6.domain.entity.CommentEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class CommentService {
	private final CommentRepository cr;
	
	// 댓글 저장
	public void write(CommentDTO dto) {
		CommentEntity entity = CommentEntity.builder()
				.name(dto.getName())
				.comment(dto.getComment()).build();
		
		cr.save(entity);
	}
	
	public List<CommentDTO> getList() {
		List<CommentEntity> entityList = cr.findAll();
		List<CommentDTO> dtoList = new ArrayList<>();
		
		for (CommentEntity entity : entityList){
			CommentDTO dto = CommentDTO.builder()
					.num(entity.getNum())
					.name(entity.getName())
					.comment(entity.getComment()).build();
			dtoList.add(dto);
			
		}
		return dtoList;
	}
}
