package com.exam.heroes.repository;

import com.exam.heroes.model.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero, String> {

    List<Hero> findAllByOrderByLevelDesc();
}
