package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.bin.Attorney;
import com.solvd.lawoffice.db.dao.AttorneyRepository;
import com.solvd.lawoffice.db.dao.jdbc.AttorneyDaoImpl;
import com.solvd.lawoffice.db.service.AttorneyAreaOfPracticeService;
import com.solvd.lawoffice.db.service.AttorneyAssociationBarService;
import com.solvd.lawoffice.db.service.AttorneyService;

import java.util.ArrayList;
import java.util.Optional;

public class AttorneyJdbcImpl implements AttorneyService {
    private final AttorneyRepository attorneyRepository;
    private final AttorneyAssociationBarService attorneyAssociationBarService;
    private final AttorneyAreaOfPracticeService attorneyAreaOfPracticeService;

    public AttorneyJdbcImpl() {
        this.attorneyRepository = new AttorneyDaoImpl();
        this.attorneyAssociationBarService = new AttorneyAssociationBarJdbcImpl();
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
