package net.datasa.spring5.security;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class AuthenticatedUser implements UserDetails {

	private String id;
	private String password;
	private String name;
	private String rolename;
	private boolean enabled;

	// ctrl + o 눌러서 오버라이딩 해야 오류없이 사용 가능

	// 계정의 유효기간이 만료되지 않았는지를 확인
	@Override
	public boolean isAccountNonExpired() {
		// return UserDetails.super.isAccountNonExpired();
		return true; // 계정이 활성화 되어있는 지 여부를 사용자가 바꿔서 만들면 됨..? 이거 좀 더 검색해보자
	}

	// 계정이 잠겨 있는지 여부를 확인
	@Override
	public boolean isAccountNonLocked() {
		// return UserDetails.super.isAccountNonLocked();
		return true; // true 하면 뭐인거지
	}

	// 비밀번호가 만료되지 않았는지를 확인 (90일마다 변경하라고 띄우는거)
	@Override
	public boolean isCredentialsNonExpired() {
		// return UserDetails.super.isCredentialsNonExpired();
		return true;
	}

	// 계쩡이 활성화되어쓰지 여부를 확인(정상 아이디인지 체크)
	@Override
	public boolean isEnabled() {
		// return UserDetails.super.isEnabled();
		return this.enabled;
	}

	// 사용자가 어떤 권한을 갖고 있는지 Spring Security에게 알려주는 메서드
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// return List.of();
		return Collections.singletonList(
				new SimpleGrantedAuthority(this.rolename));
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.id;
	}
}
