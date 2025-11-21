package net.datasa.spring3.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
//JPA에서 DB 테이블과 매피되는 자바 클래스를 정의하기 위해 사용하는 Annotation
@Entity
// Entity가 매핑될 테이블명을 지정. (생략하면클래스 이름이 테이블 이름으로 사용)
@Table(name = "person")
public class PersonEntity {
	
	// Entity 클래스의 PK 값
	@Id
	@Column(name = "id", nullable = false, length = 30)
	private String id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "age")
	private Integer age;
}
