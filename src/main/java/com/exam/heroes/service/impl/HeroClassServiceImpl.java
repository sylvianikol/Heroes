package com.exam.heroes.service.impl;

import com.exam.heroes.model.entity.ClassName;
import com.exam.heroes.model.entity.HeroClass;
import com.exam.heroes.repository.HeroClassRepository;
import com.exam.heroes.service.HeroClassService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class HeroClassServiceImpl implements HeroClassService {

    private final HeroClassRepository heroClassRepository;

    public HeroClassServiceImpl(HeroClassRepository heroClassRepository) {
        this.heroClassRepository = heroClassRepository;
    }

    @Override
    public void initClasses() {
        if (heroClassRepository.count() == 0) {

            Arrays.stream(ClassName.values()).forEach(value -> {
                HeroClass heroClass = new HeroClass();
                heroClass.setName(value);

                this.heroClassRepository.save(heroClass);
            });
        }
    }

    @Override
    public HeroClass findByName(ClassName name) {
        return this.heroClassRepository.findByName(name);
    }
}
