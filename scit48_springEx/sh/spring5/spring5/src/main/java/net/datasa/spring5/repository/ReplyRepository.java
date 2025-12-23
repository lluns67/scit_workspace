package net.datasa.spring5.repository;

import net.datasa.spring5.domain.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 리플 관련 Repository
 */
@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {
	List<ReplyEntity> findByBoard_BoardNum(Integer board_num);
	
	
	
	List<ReplyEntity> findByMember_MemberId(String replyId);
}
