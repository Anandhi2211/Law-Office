package com.solvd.law_office.db.service.jdbc;

import com.solvd.law_office.db.bin.Attorney;
import com.solvd.law_office.db.bin.LawFirm;
import com.solvd.law_office.db.dao.LawFirmRepository;
import com.solvd.law_office.db.dao.jdbc.LawFirmDaoImpl;
import com.solvd.law_office.db.service.AttorneyAssociationBarService;
import com.solvd.law_office.db.service.AttorneyService;
import com.solvd.law_office.db.service.ClientService;
import com.solvd.law_office.db.service.LawFirmService;

import java.util.ArrayList;

public class LawFirmJdbcImpl implements LawFirmService {
    private final LawFirmRepository lawFirmRepository;
    private final AttorneyService attorneyService;
    private final AttorneyAssociationBarService attorneyAssociationBarService;

    private final ClientService clientService;

    public LawFirmJdbcImpl() {
        this.lawFirmRepository = new LawFirmDaoImpl();
        this.attorneyService = new AttorneyServiceImpl();
        this.clientService = new ClientJdbcImpl();
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
