package com.solvd.law_office.db.service.jdbc;

import com.solvd.law_office.db.bin.Attorney;
import com.solvd.law_office.db.dao.AttorneyAssociationBarRepository;
import com.solvd.law_office.db.dao.jdbc.AttorneyAssociationBarDaoImpl;
import com.solvd.law_office.db.service.AttorneyAssociationBarService;

public class AttorneyAssociationBarServiceImpl implements AttorneyAssociationBarService {
    private final AttorneyAssociationBarRepository attorneyAssociationBarRepository;
    public AttorneyAssociationBarServiceImpl() {
//        this.attorneyAssociationBarRepository = new AttorneyAssociationBarRepositoryMyBatisImpl();
        this.attorneyAssociationBarRepository = new AttorneyAssociationBarDaoImpl();

    }
    @Override
    public Attorney insert(int associationBarId, Attorney attorney) {
            this.attorneyAssociationBarRepository.insert(associationBarId, attorney);
        return attorney;
    }

    @Override
    public void deleteById(int associationBarId) {
        this.attorneyAssociationBarRepository.deleteByAssociationBarId(associationBarId);
    }

    @Override
    public void addAssociationBar(int attorneyId, int associationBarId) {
        this.attorneyAssociationBarRepository.addAssociationBarId(attorneyId,associationBarId);
    }
}
