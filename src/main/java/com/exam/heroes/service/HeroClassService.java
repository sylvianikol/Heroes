package com.exam.heroes.service;

import com.exam.heroes.model.entity.ClassName;
import com.exam.heroes.model.entity.HeroClass;

public interface HeroClassService {

    void initClasses();

    HeroClass findByName(ClassName heroClass);
}
