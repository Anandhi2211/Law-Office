package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.dao.AttorneyAssociationBarRepository;
import com.solvd.law_office.dao.impl.AttorneyAssociationBarRepositoryMyBatisImpl;
import com.solvd.law_office.service.AttorneyAssociationBarService;

public class AttorneyAssociationBarServiceImpl implements AttorneyAssociationBarService {
    private final AttorneyAssociationBarRepository attorneyAssociationBarRepository;
    public AttorneyAssociationBarServiceImpl() {
        this.attorneyAssociationBarRepository = new AttorneyAssociationBarRepositoryMyBatisImpl();
    }
    @Override
    public Attorney insert(int associationBarId, Attorney attorney) {
            this.attorneyAssociationBarRepository.insert(associationBarId, attorney);
        return attorney;
    }

    @Override
    public void deleteById(int attorneyId) {
        this.attorneyAssociationBarRepository.deleteById(attorneyId);
    }

    @Override
    public void addAssociationBar(int attorneyId, int associationBarId) {
        this.attorneyAssociationBarRepository.addAssociationBarId(attorneyId,associationBarId);
    }
}
