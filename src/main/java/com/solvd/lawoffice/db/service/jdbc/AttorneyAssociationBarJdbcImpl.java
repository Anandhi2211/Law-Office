package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.binary.Attorney;
import com.solvd.lawoffice.db.dao.AttorneyAssociationBarDao;
import com.solvd.lawoffice.db.dao.jdbc.AttorneyAssociationBarDaoImpl;
import com.solvd.lawoffice.db.service.AttorneyAssociationBarService;

public class AttorneyAssociationBarJdbcImpl implements AttorneyAssociationBarService {
    private final AttorneyAssociationBarDao attorneyAssociationBarDao;
    public AttorneyAssociationBarJdbcImpl() {
//        this.attorneyAssociationBarDao = new AttorneyAssociationBarRepositoryMyBatisImpl();
        this.attorneyAssociationBarDao = new AttorneyAssociationBarDaoImpl();

    }

    public void insert(int associationBarId, int attorneyId) {
            this.attorneyAssociationBarDao.insert(associationBarId, attorneyId);
//        return attorney;
    }

    @Override
    public void deleteById(int associationBarId) {
        this.attorneyAssociationBarDao.deleteByAssociationBarId(associationBarId);
    }
}
