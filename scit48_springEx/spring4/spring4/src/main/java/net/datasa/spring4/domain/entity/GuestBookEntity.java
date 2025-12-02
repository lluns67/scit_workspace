package net.datasa.spring4.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "guestbook")

/*
	Spring Data JPA의 Auditing 기능을 사용하기 위해 Entity 클래스에 추가
	- Entity의 생성 및 수정 시점에 자동으로 트정 필드(생성일, 수정일 ..)를업데이트
	-ex.
			@CreatedDate 		최초 저장시 시간 자동 저장
			@LastModifiedDate	수정될때마다 시간 자동 갱신
			@CreateBy 			최초 저장시 작성자 저장
			@LastModifiedBy		수정 시 작성자 저장 */
@EntityListeners(AuditingEntityListener.class)
public class GuestBookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num")
	private Integer num;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	
	@Column(name= "message", nullable = false, columnDefinition = "text")
	private String message;
	
	@CreatedDate
	@Column(name="inputdate",  updatable = false)
	private LocalDateTime inputdate;
}
