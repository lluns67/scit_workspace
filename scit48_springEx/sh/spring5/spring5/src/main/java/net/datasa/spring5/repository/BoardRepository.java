package net.datasa.spring5.repository;

import net.datasa.spring5.domain.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 게시판 관련 Repository
 */
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    // JPQL : 직접 쿼리문을 입력
    // join fetch를 쓰면 N+1 문제를 방지할 수 있음.
    @Query("""
            select b
            from BoardEntity b
            join fetch b.member
            order by b.boardNum desc
            """)
	
    List<BoardEntity> findAllWithMemberOrderByBoardNumDesc();
	
	//제목에 searchWord가 포함된데이터 조회
	Page<BoardEntity> findByTitleContaining(String searchWord, Pageable pageable);
	//내용에 searchWord가 포하된 데이터 조회
	Page<BoardEntity> findByContentsContaining(String searchWord, Pageable pageable);
	//작성자ID가 searchWord와 일치하는 데이터 조회
	Page<BoardEntity> findByMember_MemberId(String searchWord, Pageable pageable);
	//제목 내용 작성자ID 모두 포함하는 통합검색
	@Query("SELECT board " +
			"FROM BoardEntity board " +
			"WHERE board.title		LIKE %:searchWord%" +
			"	OR board.contents	LIKE %:searchWord%" +
			"	OR board.member.memberId LIKE %:searchWord% " +
			"ORDER BY board.boardNum DESC"
	)
	Page<BoardEntity> searchAll(String searchWord, Pageable pageable);
}
