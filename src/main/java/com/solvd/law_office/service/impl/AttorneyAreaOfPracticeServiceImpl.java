package com.solvd.law_office.service.impl;

import com.solvd.law_office.dao.AttorneyAreaOfPracticeRepository;
import com.solvd.law_office.dao.impl.AttorneyAreaOfPracticeRepositoryMyBatisImpl;
import com.solvd.law_office.service.AttorneyAreaOfPracticeService;

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
