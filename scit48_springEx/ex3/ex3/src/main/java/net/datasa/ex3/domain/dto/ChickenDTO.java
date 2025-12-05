package net.datasa.ex3.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChickenDTO {
	 Integer id;					// PK
	
	 String chickenType;			// 치킨 종류
	 int chickenPrice;			// 치킨 가격
	 int quantity;				// 수량
	 String extraOptions;		// 추가 옵션
	 int extraTotalPrice;		// 추가 옵션 가격
	 String deliveryType;		// 배달 종류
	 int deliveryPrice;			// 배달 비용
	 int totalPrice;
	 
	 LocalDateTime orderDate;
}
