package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.AssociationBar;
import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.dao.AttorneyRepository;
import com.solvd.law_office.dao.impl.AttorneyRepositoryImpl;
import com.solvd.law_office.service.AttorneyAssociationBarService;
import com.solvd.law_office.service.AttorneyService;

public class AttorneyServiceImpl implements AttorneyService {
    private final AttorneyRepository attorneyRepository;
    private final AttorneyAssociationBarService attorneyAssociationBarService;

    public AttorneyServiceImpl() {
        this.attorneyRepository = new AttorneyRepositoryImpl();
        this.attorneyAssociationBarService = new AttorneyAssociationBarServiceImpl();
    }
    @Override
    public Attorney insert(Attorney attorney, int lawFirmId) {
        attorneyRepository.insert(attorney,lawFirmId);
        if(attorney.getAssociationBarIdList()!=null)
        {
            for(int associationBarId : attorney.getAssociationBarIdList()) {
                attorneyAssociationBarService.insert(associationBarId,attorney);
            }
        }
        return attorney;
    }
}
