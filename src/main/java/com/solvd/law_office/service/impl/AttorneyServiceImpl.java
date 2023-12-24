package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.AssociationBar;
import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.dao.AssociationBarRepository;
import com.solvd.law_office.dao.AttorneyRepository;
import com.solvd.law_office.dao.impl.AttorneyRepositoryImpl;
import com.solvd.law_office.service.AttorneyAssociationBarService;
import com.solvd.law_office.service.AttorneyService;

import java.util.ArrayList;

public class AttorneyServiceImpl implements AttorneyService {
    private final AttorneyRepository attorneyRepository;
    private final AttorneyAssociationBarService attorneyAssociationBarService;

    public AttorneyServiceImpl() {
        this.attorneyRepository = new AttorneyRepositoryImpl();
        this.attorneyAssociationBarService = new AttorneyAssociationBarServiceImpl();
    }

    @Override
    public Attorney insert(Attorney attorney, int lawFirmId) {
        attorneyRepository.insert(attorney, lawFirmId);
        return attorney;
    }

    public ArrayList<Attorney> findAll() {
        ArrayList<Attorney> attorneyList = attorneyRepository.findAll();
        return attorneyList;
    }
}
