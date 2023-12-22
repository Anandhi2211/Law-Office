package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.AssociationBar;
import com.solvd.law_office.dao.AssociationBarRepository;
import com.solvd.law_office.dao.impl.AssociationBarRepositoryImpl;
import com.solvd.law_office.service.AssociationBarService;
import com.solvd.law_office.service.AttorneyAssociationBarService;

public class AssociationBarServiceImpl implements AssociationBarService {
    private final AssociationBarRepository associationBarRepository;
    private final AttorneyAssociationBarService attorneyAssociationBarService;
    public AssociationBarServiceImpl() {
        this.associationBarRepository = new AssociationBarRepositoryImpl();
        this.attorneyAssociationBarService = new AttorneyAssociationBarServiceImpl();
    }
    @Override
    public AssociationBar insert(AssociationBar associationBar) {
        associationBarRepository.insert(associationBar);
        return associationBar;
    }
}
