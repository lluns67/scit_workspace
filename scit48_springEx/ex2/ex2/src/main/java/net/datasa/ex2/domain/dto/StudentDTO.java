package net.datasa.ex2.domain.dto;

import lombok.Data;

@Data
public class StudentDTO {
	private Integer sid;
	private String name;
	private String major;
	
	private String java;
	private String db;
	private String web;
}
