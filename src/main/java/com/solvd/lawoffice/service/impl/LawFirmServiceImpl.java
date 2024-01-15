package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.binary.Attorney;
import com.solvd.lawoffice.binary.Award;
import com.solvd.lawoffice.binary.LawFirm;
import com.solvd.lawoffice.dao.AttorneyAssociationBarDao;
import com.solvd.lawoffice.dao.LawFirmAwardDao;
import com.solvd.lawoffice.dao.LawFirmDao;
import com.solvd.lawoffice.service.AttorneyService;
import com.solvd.lawoffice.service.ClientService;
import com.solvd.lawoffice.service.LawFirmService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class LawFirmServiceImpl implements LawFirmService {
    private final LawFirmDao lawFirmDao;
    private final LawFirmAwardDao lawFirmAwardDao;
    private final AttorneyService attorneyService;
    private final AttorneyAssociationBarDao attorneyAssociationBarDao;
    private final ClientService clientService;

    public LawFirmServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.lawFirmDao = (LawFirmDao) Class.forName(path + "LawFirmImpl").getConstructor().newInstance();
            this.lawFirmAwardDao = (LawFirmAwardDao) Class.forName(path + "LawFirmAwardImpl").getConstructor().newInstance();
            this.attorneyAssociationBarDao = (AttorneyAssociationBarDao) Class.forName(path + "AttorneyAssociationBarImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.attorneyService = new AttorneyServiceImpl();
        this.clientService = new ClientServiceImpl();
    }

    @Override
    public LawFirm insert(LawFirm lawFirm) {
        this.lawFirmDao.insert(lawFirm);
        if (lawFirm.getAwardList() != null) {
            for (Award award : lawFirm.getAwardList()) {
                lawFirmAwardDao.insert(award, lawFirm.getLawFirmId());
            }
        }
        if (lawFirm.getAttorneyList() != null) {
            for (Attorney attorney : lawFirm.getAttorneyList()) {
                this.attorneyService.insert(attorney, lawFirm.getLawFirmId());
                if (attorney.getAssociationBarIdList() != null) {
                    for (Integer associationBarId : attorney.getAssociationBarIdList()) {
                        this.attorneyAssociationBarDao.insert(associationBarId, attorney.getAttorneyId());
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
