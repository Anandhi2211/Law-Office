package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.dao.AttorneyRepository;
import com.solvd.law_office.dao.impl.AttorneyRepositoryImpl;
import com.solvd.law_office.service.AttorneyService;

public class AttorneyServiceImpl implements AttorneyService {
    private final AttorneyRepository attorneyRepository;

    public AttorneyServiceImpl() {
        this.attorneyRepository = new AttorneyRepositoryImpl();
    }

//    public Attorney create(Attorney attorney){
//
//
//    }
}
