package com.exam.heroes.service.impl;

import com.exam.heroes.model.entity.Hero;
import com.exam.heroes.model.service.HeroServiceModel;
import com.exam.heroes.repository.HeroRepository;
import com.exam.heroes.service.HeroClassService;
import com.exam.heroes.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;
    private final HeroClassService heroClassService;
    private final ModelMapper modelMapper;

    public HeroServiceImpl(HeroRepository heroRepository, HeroClassService heroClassService, ModelMapper modelMapper) {
        this.heroRepository = heroRepository;
        this.heroClassService = heroClassService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<HeroServiceModel> getAll() {
        return this.heroRepository.findAll().stream()
                .map(hero -> {
                    HeroServiceModel heroServiceModel = this.modelMapper.map(hero, HeroServiceModel.class);
                    heroServiceModel.setHeroClass(hero.getaHeroClass().getName());
                    return heroServiceModel;
                })
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean add(HeroServiceModel heroServiceModel) {
        Hero hero = this.modelMapper.map(heroServiceModel, Hero.class);
        hero.setaHeroClass(this.heroClassService.findByName(heroServiceModel.getHeroClass()));

        try {
            this.heroRepository.save(hero);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
