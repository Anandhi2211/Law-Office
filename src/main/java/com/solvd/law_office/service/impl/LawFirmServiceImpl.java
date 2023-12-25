package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.bin.LawFirm;
import com.solvd.law_office.dao.LawFirmRepository;
import com.solvd.law_office.dao.impl.LawFirmRepositoryImpl;
import com.solvd.law_office.dao.impl.LawFirmRepositoryMyBatisImpl;
import com.solvd.law_office.service.AttorneyAssociationBarService;
import com.solvd.law_office.service.AttorneyService;
import com.solvd.law_office.service.ClientService;
import com.solvd.law_office.service.LawFirmService;

import java.util.ArrayList;

public class LawFirmServiceImpl implements LawFirmService {
    private final LawFirmRepository lawFirmRepository;
    private final AttorneyService attorneyService;
    private final AttorneyAssociationBarService attorneyAssociationBarService;

    private final ClientService clientService;

    public LawFirmServiceImpl() {
        this.lawFirmRepository = new LawFirmRepositoryMyBatisImpl();
        this.attorneyService = new AttorneyServiceImpl();
        this.clientService = new ClientServiceImpl();
        this. attorneyAssociationBarService = new AttorneyAssociationBarServiceImpl();
    }
    @Override
    public LawFirm insert(LawFirm lawFirm) {
        lawFirmRepository.insert(lawFirm);
        if (lawFirm.getAttorneyList() != null) {
            for (Attorney attorney : lawFirm.getAttorneyList()) {
                this.attorneyService.insert(attorney, lawFirm.getLawFirmId());
                if(attorney.getAssociationBarIdList()!=null){
                    for(Integer associationBarId : attorney.getAssociationBarIdList()){
                        this.attorneyAssociationBarService.insert(associationBarId, attorney);
                    }
                }
            }
        }
        return lawFirm;
    }
    @Override
    public ArrayList<LawFirm> findAll() {
        ArrayList<LawFirm> lawFirmList = lawFirmRepository.findAll();
        return lawFirmList;
    }
}
