package com.exam.heroes.service.impl;

import com.exam.heroes.model.service.HeroServiceModel;
import com.exam.heroes.repository.HeroRepository;
import com.exam.heroes.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;
    private final ModelMapper modelMapper;

    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper) {
        this.heroRepository = heroRepository;
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
}
