package com.exam.heroes.model.binding;

import com.exam.heroes.model.entity.ClassName;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class HeroCreateBindingModel {

    private String name;
    private String imageUrl;
    private ClassName heroClass;
    private int level;

    public HeroCreateBindingModel() {
    }

    @NotBlank(message = "Name can not be null or empty")
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Image URL can not be empty")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NotNull(message = "Hero class can not be null")
    public ClassName getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(ClassName heroClass) {
        this.heroClass = heroClass;
    }

    @Min(value = 0, message = "Level can not be a negative number")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
