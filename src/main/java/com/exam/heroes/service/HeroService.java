package com.exam.heroes.service;

import com.exam.heroes.model.service.HeroServiceModel;

import java.util.List;

public interface HeroService {

    List<HeroServiceModel> getAll();

    boolean add(HeroServiceModel heroServiceModel);

    HeroServiceModel getById(String id);

    void deleteById(String id);
}
