package com.exam.heroes.init;

import com.exam.heroes.service.HeroClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final HeroClassService heroClassService;

    @Autowired
    public DataInit(HeroClassService heroClassService) {
        this.heroClassService = heroClassService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.heroClassService.initClasses();
    }
}
