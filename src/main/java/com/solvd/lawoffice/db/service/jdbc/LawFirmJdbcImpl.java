package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.bin.Attorney;
import com.solvd.lawoffice.db.bin.LawFirm;
import com.solvd.lawoffice.db.dao.LawFirmRepository;
import com.solvd.lawoffice.db.dao.jdbc.LawFirmDaoImpl;
import com.solvd.lawoffice.db.service.AttorneyAssociationBarService;
import com.solvd.lawoffice.db.service.AttorneyService;
import com.solvd.lawoffice.db.service.ClientService;
import com.solvd.lawoffice.db.service.LawFirmService;

import java.util.ArrayList;

public class LawFirmJdbcImpl implements LawFirmService {
    private final LawFirmRepository lawFirmRepository;
    private final AttorneyService attorneyService;
    private final AttorneyAssociationBarService attorneyAssociationBarService;

    private final ClientService clientService;

    public LawFirmJdbcImpl() {
        this.lawFirmRepository = new LawFirmDaoImpl();
        this.attorneyService = new AttorneyJdbcImpl();
        this.clientService = new ClientJdbcImpl();
        this. attorneyAssociationBarService = new AttorneyAssociationBarJdbcImpl();
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
