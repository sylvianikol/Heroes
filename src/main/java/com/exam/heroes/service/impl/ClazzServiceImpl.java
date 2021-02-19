package com.exam.heroes.service.impl;

import com.exam.heroes.model.entity.ClassName;
import com.exam.heroes.model.entity.Clazz;
import com.exam.heroes.repository.ClazzRepository;
import com.exam.heroes.service.ClazzService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClazzServiceImpl implements ClazzService {

    private final ClazzRepository clazzRepository;

    public ClazzServiceImpl(ClazzRepository clazzRepository) {
        this.clazzRepository = clazzRepository;
    }

    @Override
    public void initClasses() {
        if (clazzRepository.count() == 0) {

            Arrays.stream(ClassName.values()).forEach(value -> {
                Clazz clazz = new Clazz();
                clazz.setName(value);

                this.clazzRepository.save(clazz);
            });
        }
    }
}
