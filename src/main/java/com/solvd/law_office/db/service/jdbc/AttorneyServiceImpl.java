package com.solvd.law_office.db.service.jdbc;

import com.solvd.law_office.db.bin.Attorney;
import com.solvd.law_office.db.dao.AttorneyRepository;
import com.solvd.law_office.db.dao.jdbc.AttorneyDaoImpl;
import com.solvd.law_office.db.service.AttorneyAreaOfPracticeService;
import com.solvd.law_office.db.service.AttorneyAssociationBarService;
import com.solvd.law_office.db.service.AttorneyService;

import java.util.ArrayList;
import java.util.Optional;

public class AttorneyServiceImpl implements AttorneyService {
    private final AttorneyRepository attorneyRepository;
    private final AttorneyAssociationBarService attorneyAssociationBarService;
    private final AttorneyAreaOfPracticeService attorneyAreaOfPracticeService;

    public AttorneyServiceImpl() {
        this.attorneyRepository = new AttorneyDaoImpl();
        this.attorneyAssociationBarService = new AttorneyAssociationBarServiceImpl();
        this.attorneyAreaOfPracticeService = new AttorneyAreaOfPracticeServiceImpl();
    }

    @Override
    public Attorney insert(Attorney attorney, int lawFirmId) {
        attorneyRepository.insert(attorney, lawFirmId);
        return attorney;
    }

    @Override
    public void deleteById(int attorneyId) {
        attorneyAssociationBarService.deleteById(attorneyId);
        attorneyAreaOfPracticeService.deleteById(attorneyId);
            attorneyRepository.deleteById(attorneyId);

    }

    public Optional<Attorney> findById(int attorneyId) {
        Optional<Attorney> attorneyList = attorneyRepository.findById(attorneyId);
        return attorneyList;
    }

    @Override
    public ArrayList<Attorney> findByCountry(String country) {
        ArrayList<Attorney> attorneyList = attorneyRepository.findByCountry(country);
        return attorneyList;    }

    @Override
    public void updateCityById(int attorneyId, String city) {
        attorneyRepository.updateCityById(attorneyId,city);
    }

    @Override
    public void addAssociationBar(int attorneyId, int associationBarId) {
        attorneyAssociationBarService.addAssociationBar(attorneyId,associationBarId);
    }


    public ArrayList<Attorney> findAll() {
        ArrayList<Attorney> attorneyList = attorneyRepository.findAll();
        return attorneyList;
    }

}
