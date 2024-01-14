package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.binary.Attorney;
import com.solvd.lawoffice.binary.LawFirm;
import com.solvd.lawoffice.dao.LawFirmDao;
import com.solvd.lawoffice.service.AttorneyAssociationBarService;
import com.solvd.lawoffice.service.AttorneyService;
import com.solvd.lawoffice.service.ClientService;
import com.solvd.lawoffice.service.LawFirmService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
public class LawFirmServiceImpl implements LawFirmService {
    private final LawFirmDao lawFirmDao;
    private final AttorneyService attorneyService;
    private final AttorneyAssociationBarService attorneyAssociationBarService;
    private final ClientService clientService;
    public LawFirmServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.lawFirmDao = (LawFirmDao) Class.forName(path+"LawFirmImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.attorneyService = new AttorneyServiceImpl();
        this.clientService = new ClientServiceImpl();
        this.attorneyAssociationBarService = new AttorneyAssociationBarServiceImpl();
    }
    @Override
    public LawFirm insert(LawFirm lawFirm) {
        lawFirmDao.insert(lawFirm);
        if (lawFirm.getAttorneyList() != null) {
            for (Attorney attorney : lawFirm.getAttorneyList()) {
                this.attorneyService.insert(attorney, lawFirm.getLawFirmId());
                if(attorney.getAssociationBarIdList()!=null){
                    for(Integer associationBarId : attorney.getAssociationBarIdList()){
                        this.attorneyAssociationBarService.insert(associationBarId, attorney.getAttorneyId());
                    }
                }
            }
        }
        return lawFirm;
    }
    @Override
    public ArrayList<LawFirm> findAll() {
        ArrayList<LawFirm> lawFirmList = lawFirmDao.findAll();
        return lawFirmList;
    }
}
