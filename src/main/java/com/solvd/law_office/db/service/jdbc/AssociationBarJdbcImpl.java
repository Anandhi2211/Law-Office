package com.solvd.law_office.db.service.jdbc;

import com.solvd.law_office.db.bin.AssociationBar;
import com.solvd.law_office.db.dao.AssociationBarRepository;
import com.solvd.law_office.db.dao.jdbc.AssociationBarDaoImpl;
import com.solvd.law_office.db.service.AssociationBarService;
import com.solvd.law_office.db.service.AttorneyAssociationBarService;


public class AssociationBarJdbcImpl implements AssociationBarService {
    private final AssociationBarRepository associationBarRepository;
    private final AttorneyAssociationBarService attorneyAssociationBarService;
    public AssociationBarJdbcImpl() {
        this.associationBarRepository = new AssociationBarDaoImpl();
        this.attorneyAssociationBarService = new AttorneyAssociationBarServiceImpl();
    }
    @Override
    public AssociationBar insert(AssociationBar associationBar) {
        associationBarRepository.insert(associationBar);
        return associationBar;
    }

    @Override
    public void deleteById(int associationBarId) {
        attorneyAssociationBarService.deleteById(associationBarId);
        associationBarRepository.deleteByAssociationBarId(associationBarId);
    }
}
