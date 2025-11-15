package net.datasa.spring2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/* Lombok
	자바 어플리케이션 개발에서 중복코드를 줄여주는 라이브러리
	Anotation 기반으로 코드를 줄여주고 가독성을 높여줌.
	
	@Data
	= @Getter, @Seeter, @ToSring, @EqualsAndHashCode
	@NoArgsConstructor	: 매개변수ㅜ가 없는 기본 생성자
	@AllArgsConstructor : 모든 필드를 매개변수로 가지는 생성자
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	String id;
	String name;
	String password;
	String phone;
	String com;
}


