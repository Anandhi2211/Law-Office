package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.binary.Attorney;
import com.solvd.lawoffice.dao.AttorneyDao;
import com.solvd.lawoffice.service.AttorneyAreaOfPracticeService;
import com.solvd.lawoffice.service.AttorneyAssociationBarService;
import com.solvd.lawoffice.service.AttorneyService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Optional;

public class AttorneyServiceImpl implements AttorneyService {
    private final AttorneyDao attorneyDao;
    private final AttorneyAssociationBarService attorneyAssociationBarService;
    private final AttorneyAreaOfPracticeService attorneyAreaOfPracticeService;

    public AttorneyServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.attorneyDao = (AttorneyDao) Class.forName(path+"AttorneyImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.attorneyAssociationBarService = new AttorneyAssociationBarServiceImpl();
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
    public Optional<Attorney> findByName(String name) {
        Optional<Attorney> attorneyList = attorneyDao.findByName(name);
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
