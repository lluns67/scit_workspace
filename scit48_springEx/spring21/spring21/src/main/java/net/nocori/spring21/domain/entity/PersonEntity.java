package net.nocori.spring21.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "person")
@Entity
public class PersonEntity {

//	키깂
	@Id
	@Column(name = "id", nullable = false, length = 30)
	private String id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "age")
	private Integer age;
}
