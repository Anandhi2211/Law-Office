package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.bin.AreaOfPractice;
import com.solvd.lawoffice.db.dao.AreaOfPracticeDao;
import com.solvd.lawoffice.db.service.mybatis.AreaOfPracticeDaoMyBatis;
import com.solvd.lawoffice.db.service.AreaOfPracticeService;

public class AreaOfPracticeServiceImpl implements AreaOfPracticeService {

    private final AreaOfPracticeDao areaOfPracticeRepository;

    public AreaOfPracticeServiceImpl() {
        this.areaOfPracticeRepository = new AreaOfPracticeDaoMyBatis();
    }

    public AreaOfPractice insert(AreaOfPractice areaOfPractice) {
        this.areaOfPracticeRepository.insert(areaOfPractice);
                return areaOfPractice;
    }
}
