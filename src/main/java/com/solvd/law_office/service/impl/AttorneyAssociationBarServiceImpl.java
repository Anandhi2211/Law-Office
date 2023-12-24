package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.AssociationBar;
import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.dao.AttorneyAssociationBarRepository;
import com.solvd.law_office.dao.impl.AttorneyAssociationBarRepositoryImpl;
import com.solvd.law_office.service.AttorneyAssociationBarService;

public class AttorneyAssociationBarServiceImpl implements AttorneyAssociationBarService {
    private final AttorneyAssociationBarRepository attorneyAssociationBarRepository;
    public AttorneyAssociationBarServiceImpl() {
        this.attorneyAssociationBarRepository = new AttorneyAssociationBarRepositoryImpl();
    }
    @Override
    public Attorney insert(int associationBarId, Attorney attorney) {
            this.attorneyAssociationBarRepository.insert(associationBarId, attorney);
        return attorney;
    }
}
