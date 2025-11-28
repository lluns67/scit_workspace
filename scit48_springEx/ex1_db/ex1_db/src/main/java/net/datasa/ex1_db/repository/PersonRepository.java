package net.datasa.ex1_db.repository;

import net.datasa.ex1_db.domain.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {

}
