package net.datasa.spring6.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ajax_member")
@Builder
public class MemberEntity {
	@Id
	String id;
	String name;
	
}

//
//id  varchar(30) primary key,
//name varchar(30) not null
