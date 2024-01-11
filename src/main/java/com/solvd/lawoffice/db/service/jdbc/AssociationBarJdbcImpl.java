package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.bin.AssociationBar;
import com.solvd.lawoffice.db.dao.AssociationBarDao;
import com.solvd.lawoffice.db.dao.jdbc.AssociationBarDaoImpl;
import com.solvd.lawoffice.db.service.AssociationBarService;
import com.solvd.lawoffice.db.service.AttorneyAssociationBarService;


public class AssociationBarJdbcImpl implements AssociationBarService {
    private final AssociationBarDao associationBarDao;
    private final AttorneyAssociationBarService attorneyAssociationBarService;
    public AssociationBarJdbcImpl() {
        this.associationBarDao = new AssociationBarDaoImpl();
        this.attorneyAssociationBarService = new AttorneyAssociationBarJdbcImpl();
    }
    @Override
    public AssociationBar insert(AssociationBar associationBar) {
        associationBarDao.insert(associationBar);
        return associationBar;
    }

    @Override
    public void deleteById(int associationBarId) {
        attorneyAssociationBarService.deleteById(associationBarId);
        associationBarDao.deleteByAssociationBarId(associationBarId);
    }
}
