package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.bin.Attorney;
import com.solvd.lawoffice.db.dao.AttorneyAssociationBarDao;
import com.solvd.lawoffice.db.dao.jdbc.AttorneyAssociationBarDaoImpl;
import com.solvd.lawoffice.db.service.AttorneyAssociationBarService;

public class AttorneyAssociationBarJdbcImpl implements AttorneyAssociationBarService {
    private final AttorneyAssociationBarDao attorneyAssociationBarDao;
    public AttorneyAssociationBarJdbcImpl() {
//        this.attorneyAssociationBarDao = new AttorneyAssociationBarRepositoryMyBatisImpl();
        this.attorneyAssociationBarDao = new AttorneyAssociationBarDaoImpl();

    }
    @Override
    public Attorney insert(int associationBarId, Attorney attorney) {
            this.attorneyAssociationBarDao.insert(associationBarId, attorney);
        return attorney;
    }

    @Override
    public void deleteById(int associationBarId) {
        this.attorneyAssociationBarDao.deleteByAssociationBarId(associationBarId);
    }

    @Override
    public void addAssociationBar(int attorneyId, int associationBarId) {
        this.attorneyAssociationBarDao.addAssociationBarId(attorneyId,associationBarId);
    }
}
