package net.datasa.ex3.repository;

import net.datasa.ex3.domain.entity.ChickenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChickenRepository extends JpaRepository<ChickenEntity,Integer> {
}
