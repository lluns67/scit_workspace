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

@Entity
@Data
@Table(name = "guestbook_recommend")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuestBookRecommendEntity {
	
	@EmbeddedId
	private GuestBookRecommendKey id;
	
	@CreatedDate
	@Column(name = "create_at", nullable = false)
	private LocalDateTime createdAt;
}
