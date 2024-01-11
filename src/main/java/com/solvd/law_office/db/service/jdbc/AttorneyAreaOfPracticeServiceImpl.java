package com.solvd.law_office.db.service.jdbc;

import com.solvd.law_office.db.dao.AttorneyAreaOfPracticeRepository;
import com.solvd.law_office.db.service.mybatis.AttorneyAreaOfPracticeRepositoryMyBatisImpl;
import com.solvd.law_office.db.service.AttorneyAreaOfPracticeService;

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
