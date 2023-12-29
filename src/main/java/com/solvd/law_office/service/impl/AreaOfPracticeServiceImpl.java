package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.AreaOfPractice;
import com.solvd.law_office.dao.AreaOfPracticeRepository;
import com.solvd.law_office.dao.impl.AreaOfPracticeRepositoryMyBatis;
import com.solvd.law_office.service.AreaOfPracticeService;

public class AreaOfPracticeServiceImpl implements AreaOfPracticeService {

    private final AreaOfPracticeRepository areaOfPracticeRepository;

    public AreaOfPracticeServiceImpl() {
        this.areaOfPracticeRepository = new AreaOfPracticeRepositoryMyBatis();
    }

    public AreaOfPractice insert(AreaOfPractice areaOfPractice) {
        this.areaOfPracticeRepository.insert(areaOfPractice);
                return areaOfPractice;
    }
}
