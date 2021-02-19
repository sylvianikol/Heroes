package com.exam.heroes.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity {

    private String name;
    private String imageUrl;
    private HeroClass heroClass;
    private int level;

    public Hero() {
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String image) {
        this.imageUrl = image;
    }

    @ManyToOne
    public HeroClass getaHeroClass() {
        return heroClass;
    }

    public void setaHeroClass(HeroClass aHeroClass) {
        this.heroClass = aHeroClass;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
