package com.exam.heroes.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "classes")
public class Clazz extends BaseEntity {

    private ClassName name;

    public Clazz() {
    }

    @Enumerated(value = EnumType.STRING)
    public ClassName getName() {
        return name;
    }

    public void setName(ClassName name) {
        this.name = name;
    }
}
