package net.datasa.spring6.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring6.Repository.BoardRepository;
import net.datasa.spring6.Repository.CommentRepository;
import net.datasa.spring6.Repository.MemberRepository;
import net.datasa.spring6.domain.dto.MemberDTO;
import net.datasa.spring6.domain.entity.BoardEntity;
import net.datasa.spring6.domain.entity.MemberEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ExService {
	
	private final BoardRepository boardRepository;
	private final MemberRepository memberRepository;
	private final CommentRepository commentRepository;
	
	public int readLike(Integer num) {
		BoardEntity entity = boardRepository.findById(num)
				.orElseThrow(
						()-> new EntityNotFoundException("게시글이 없습니다.")
				);
		return entity.getCnt();
	}
	
	public int readPlus(Integer num) {
		BoardEntity entity = boardRepository.findById(num)
				.orElseThrow(
						()-> new EntityNotFoundException("게시글이 없습니다.")
				);
		int n = entity.getCnt();
		n++;
		entity.setCnt(n);
		return n;
	}
	
	public Boolean idCheck(String id) {
		 return memberRepository.existsById(id);
			
	}
	
	public void join(MemberDTO dto) {
		MemberEntity entity = MemberEntity.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
		memberRepository.save(entity);
	}
	
	
}