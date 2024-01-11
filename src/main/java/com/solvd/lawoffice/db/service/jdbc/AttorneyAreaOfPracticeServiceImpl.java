package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.dao.AttorneyAreaOfPracticeRepository;
import com.solvd.lawoffice.db.service.mybatis.AttorneyAreaOfPracticeRepositoryMyBatisImpl;
import com.solvd.lawoffice.db.service.AttorneyAreaOfPracticeService;

public class AttorneyAreaOfPracticeServiceImpl implements AttorneyAreaOfPracticeService {

    private final AttorneyAreaOfPracticeRepository areaOfPracticeRepository ;

    public AttorneyAreaOfPracticeServiceImpl() {
        this.areaOfPracticeRepository = new AttorneyAreaOfPracticeRepositoryMyBatisImpl();
    }

    @Override
    public void deleteById(int attorneyId) {
        this.areaOfPracticeRepository.deleteById(attorneyId);

    }
}
