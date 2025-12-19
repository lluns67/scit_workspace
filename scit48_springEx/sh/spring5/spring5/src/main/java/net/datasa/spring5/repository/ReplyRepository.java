package net.datasa.spring5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.datasa.spring5.domain.entity.ReplyEntity;

/**
 * 리플 관련 Repository
 */
@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {

}
