package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.binary.AssociationBar;
import com.solvd.lawoffice.dao.AssociationBarDao;
import com.solvd.lawoffice.dao.AttorneyAssociationBarDao;
import com.solvd.lawoffice.service.AssociationBarService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;


public class AssociationBarServiceImpl implements AssociationBarService {
    private final AssociationBarDao associationBarDao;
    private final AttorneyAssociationBarDao attorneyAssociationBarDao;

    public AssociationBarServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.attorneyAssociationBarDao = (AttorneyAssociationBarDao) Class.forName(path + "AttorneyAssociationBarImpl").getConstructor().newInstance();

            this.associationBarDao = (AssociationBarDao) Class.forName(path + "AssociationBarImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AssociationBar insert(AssociationBar associationBar) {
        associationBarDao.insert(associationBar);
        return associationBar;
    }

    @Override
    public void deleteByAssociationBarId(int associationBarId) {
        attorneyAssociationBarDao.deleteByAssociationBarId(associationBarId);
        associationBarDao.deleteByAssociationBarId(associationBarId);
    }
}
