package com.exam.heroes.repository;

import com.exam.heroes.model.entity.HeroClass;
import com.exam.heroes.model.entity.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroClassRepository extends JpaRepository<HeroClass, String> {

    HeroClass findByName(ClassName name);
}
