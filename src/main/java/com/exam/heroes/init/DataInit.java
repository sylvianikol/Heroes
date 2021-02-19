package com.exam.heroes.init;

import com.exam.heroes.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final ClazzService clazzService;

    @Autowired
    public DataInit(ClazzService clazzService) {
        this.clazzService = clazzService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.clazzService.initClasses();
    }
}
