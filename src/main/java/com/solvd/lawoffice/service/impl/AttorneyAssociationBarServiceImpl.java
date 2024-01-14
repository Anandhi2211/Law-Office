package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.dao.AttorneyAssociationBarDao;
import com.solvd.lawoffice.service.AttorneyAssociationBarService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;

public class AttorneyAssociationBarServiceImpl implements AttorneyAssociationBarService {
    private final AttorneyAssociationBarDao attorneyAssociationBarDao;
    public AttorneyAssociationBarServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.attorneyAssociationBarDao = (AttorneyAssociationBarDao) Class.forName(path+"AttorneyAssociationBarImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }    }

    public void insert(int associationBarId, int attorneyId) {
            this.attorneyAssociationBarDao.insert(associationBarId, attorneyId);
    }

    @Override
    public void deleteById(int associationBarId) {
        this.attorneyAssociationBarDao.deleteByAssociationBarId(associationBarId);
    }
}
