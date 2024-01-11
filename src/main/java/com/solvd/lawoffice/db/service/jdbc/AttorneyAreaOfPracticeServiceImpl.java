package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.dao.AttorneyAreaOfPracticeDao;
import com.solvd.lawoffice.db.service.mybatis.AttorneyAreaOfPracticeDaoMyBatisImpl;
import com.solvd.lawoffice.db.service.AttorneyAreaOfPracticeService;

public class AttorneyAreaOfPracticeServiceImpl implements AttorneyAreaOfPracticeService {

    private final AttorneyAreaOfPracticeDao areaOfPracticeRepository ;

    public AttorneyAreaOfPracticeServiceImpl() {
        this.areaOfPracticeRepository = new AttorneyAreaOfPracticeDaoMyBatisImpl();
    }

    @Override
    public void deleteById(int attorneyId) {
        this.areaOfPracticeRepository.deleteById(attorneyId);

    }
}
