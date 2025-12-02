package net.datasa.spring4.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.spring4.domain.dto.GuestBookDTO;
import net.datasa.spring4.domain.entity.GuestBookEntity;
import net.datasa.spring4.repository.GuestBookRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class GuestBookService {
	
	private final GuestBookRepository gr;
	
	public void test() {
		
		GuestBookEntity entity = GuestBookEntity.builder()
				// num 은 auto_increment에 의해서 생성
				.name("작성자")
				.password("111")
				.message("글저장 테스트 중")
				//inputdate는 Auditing에 의해서 생성
				.build();
		
		gr.save(entity);
	}
	
	public void write(GuestBookDTO dto) {
		if(dto.getName().length() > 100){
			dto.setName(dto.getName().substring(0,100));
		}
		if(dto.getPassword().length() > 100){
			dto.setPassword(dto.getPassword().substring(0,100));
		}
		
		GuestBookEntity entity = GuestBookEntity.builder()
				.name(dto.getName())
				.password(dto.getPassword())
				.message(dto.getMessage())
				.build();
		
		gr.save(entity);
	}
}
