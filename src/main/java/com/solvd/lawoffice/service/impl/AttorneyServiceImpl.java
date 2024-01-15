package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.binary.Attorney;
import com.solvd.lawoffice.dao.AttorneyAreaOfPracticeDao;
import com.solvd.lawoffice.dao.AttorneyAssociationBarDao;
import com.solvd.lawoffice.dao.AttorneyDao;
import com.solvd.lawoffice.service.AttorneyService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Optional;

public class AttorneyServiceImpl implements AttorneyService {
    private final AttorneyDao attorneyDao;
    private final AttorneyAssociationBarDao attorneyAssociationBarDao;
    private final AttorneyAreaOfPracticeDao attorneyAreaOfPracticeDao;

    public AttorneyServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.attorneyDao = (AttorneyDao) Class.forName(path + "AttorneyImpl").getConstructor().newInstance();
            this.attorneyAreaOfPracticeDao = (AttorneyAreaOfPracticeDao) Class.forName(path + "AttorneyAreaOfPracticeImpl").getConstructor().newInstance();
            this.attorneyAssociationBarDao = (AttorneyAssociationBarDao) Class.forName(path + "AttorneyAssociationBarImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Attorney insert(Attorney attorney, int lawFirmId) {
        this.attorneyDao.insert(attorney, lawFirmId);
        return attorney;
    }

    @Override
    public void deleteAttorneyById(int attorneyId) {
        this.attorneyAssociationBarDao.deleteAttorneyById(attorneyId);
        this.attorneyAreaOfPracticeDao.deleteAttorneyById(attorneyId);
        this.attorneyDao.deleteById(attorneyId);
    }

    public Optional<Attorney> findById(int attorneyId) {
        Optional<Attorney> attorneyList = this.attorneyDao.findById(attorneyId);
        return attorneyList;
    }

    @Override
    public Optional<Attorney> findByName(String name) {
        Optional<Attorney> attorneyList = this.attorneyDao.findByName(name);
        return attorneyList;
    }

    @Override
    public void updateCityById(int attorneyId, String city) {
        this.attorneyDao.updateCityById(attorneyId, city);
    }

    @Override
    public void insertAttorneyAssociationBar(int associationBarId, int attorneyId) {
        this.attorneyAssociationBarDao.insert(associationBarId, attorneyId);
    }

    public ArrayList<Attorney> findAll() {
        ArrayList<Attorney> attorneyList = this.attorneyDao.findAll();
        return attorneyList;
    }
}
