package net.datasa.spring4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


// JPA Auditingg 기능 활성화
// 이 설정이 있어야 @CreatedDate, @LastModifiedDate 가 동작함
@EnableJpaAuditing
@SpringBootApplication
public class Spring4Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring4Application.class, args);
	}

}

