package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.bin.AreaOfPractice;
import com.solvd.lawoffice.db.dao.AreaOfPracticeRepository;
import com.solvd.lawoffice.db.service.mybatis.AreaOfPracticeRepositoryMyBatis;
import com.solvd.lawoffice.db.service.AreaOfPracticeService;

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
