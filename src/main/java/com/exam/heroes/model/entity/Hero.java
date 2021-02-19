package com.exam.heroes.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity {

    private String name;
    private Clazz aClazz;
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

    @ManyToOne
    public Clazz getaClass() {
        return aClazz;
    }

    public void setaClass(Clazz aClazz) {
        this.aClazz = aClazz;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
