package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.binary.AreaOfPractice;
import com.solvd.lawoffice.db.dao.AreaOfPracticeDao;
import com.solvd.lawoffice.db.service.mybatis.AreaOfPracticeMyBatis;
import com.solvd.lawoffice.db.service.AreaOfPracticeService;

public class AreaOfPracticeServiceImpl implements AreaOfPracticeService {

    private final AreaOfPracticeDao areaOfPracticeRepository;

    public AreaOfPracticeServiceImpl() {
        this.areaOfPracticeRepository = new AreaOfPracticeMyBatis();
    }

    public AreaOfPractice insert(AreaOfPractice areaOfPractice) {
        this.areaOfPracticeRepository.insert(areaOfPractice);
                return areaOfPractice;
    }
}
