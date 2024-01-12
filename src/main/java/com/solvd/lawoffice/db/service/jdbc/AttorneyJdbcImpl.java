package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.binary.Attorney;
import com.solvd.lawoffice.db.dao.AttorneyDao;
import com.solvd.lawoffice.db.dao.jdbc.AttorneyDaoImpl;
import com.solvd.lawoffice.db.service.AttorneyAreaOfPracticeService;
import com.solvd.lawoffice.db.service.AttorneyAssociationBarService;
import com.solvd.lawoffice.db.service.AttorneyService;

import java.util.ArrayList;
import java.util.Optional;

public class AttorneyJdbcImpl implements AttorneyService {
    private final AttorneyDao attorneyDao;
    private final AttorneyAssociationBarService attorneyAssociationBarService;
    private final AttorneyAreaOfPracticeService attorneyAreaOfPracticeService;

    public AttorneyJdbcImpl() {
        this.attorneyDao = new AttorneyDaoImpl();
        this.attorneyAssociationBarService = new AttorneyAssociationBarJdbcImpl();
        this.attorneyAreaOfPracticeService = new AttorneyAreaOfPracticeServiceImpl();
    }

    @Override
    public Attorney insert(Attorney attorney, int lawFirmId) {
        attorneyDao.insert(attorney, lawFirmId);
        return attorney;
    }

    @Override
    public void deleteById(int attorneyId) {
        attorneyAssociationBarService.deleteById(attorneyId);
        attorneyAreaOfPracticeService.deleteById(attorneyId);
            attorneyDao.deleteById(attorneyId);

    }

    public Optional<Attorney> findById(int attorneyId) {
        Optional<Attorney> attorneyList = attorneyDao.findById(attorneyId);
        return attorneyList;
    }

    @Override
    public void updateCityById(int attorneyId, String city) {
        this.attorneyDao.updateCityById(attorneyId,city);
    }

    @Override
    public void addAssociationBar(int attorneyId, int associationBarId) {
        attorneyAssociationBarService.insert(attorneyId,associationBarId);
    }


    public ArrayList<Attorney> findAll() {
        ArrayList<Attorney> attorneyList = attorneyDao.findAll();
        return attorneyList;
    }

}
