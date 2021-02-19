package com.exam.heroes.model.service;

import com.exam.heroes.model.entity.ClassName;

public class HeroServiceModel extends BaseServiceModel {

    private String name;
    private String imageUrl;
    private ClassName heroClass;
    private int level;

    public HeroServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ClassName getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(ClassName heroClass) {
        this.heroClass = heroClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
