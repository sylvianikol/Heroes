package com.exam.heroes.repository;

import com.exam.heroes.model.entity.Clazz;
import com.exam.heroes.model.entity.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClazzRepository extends JpaRepository<Clazz, String> {

    Clazz findByName(ClassName name);
}
