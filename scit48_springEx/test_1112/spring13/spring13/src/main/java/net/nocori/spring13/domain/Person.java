package net.nocori.spring13.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {
	String id;
	String name;
	String password;
	String phone;
	String com;
}
