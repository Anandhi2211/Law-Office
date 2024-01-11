package com.solvd.law_office.db.service.jdbc;

import com.solvd.law_office.db.bin.AreaOfPractice;
import com.solvd.law_office.db.dao.AreaOfPracticeRepository;
import com.solvd.law_office.db.service.mybatis.AreaOfPracticeRepositoryMyBatis;
import com.solvd.law_office.db.service.AreaOfPracticeService;

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
