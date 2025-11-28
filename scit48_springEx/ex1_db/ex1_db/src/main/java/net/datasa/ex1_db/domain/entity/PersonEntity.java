package net.datasa.ex1_db.domain.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "person")
public class PersonEntity {
	
	@Id
	//키 값
	@Column(name="id", nullable = false, length = 30)
	private String id;
	
	@Column(name="name", length = 15)
	private String name;
	
	@Column(name="age")
	private Integer age;
}
