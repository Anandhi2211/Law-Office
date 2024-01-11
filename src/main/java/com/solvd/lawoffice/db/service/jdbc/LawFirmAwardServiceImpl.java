package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.bin.Award;
import com.solvd.lawoffice.db.dao.LawFirmAwardDao;
import com.solvd.lawoffice.db.dao.jdbc.LawFirmAwardDaoImpl;
import com.solvd.lawoffice.db.service.LawFirmAwardService;

public class LawFirmAwardServiceImpl implements LawFirmAwardService {
    private final LawFirmAwardDao lawFirmAwardDao;

    public LawFirmAwardServiceImpl() {
        this.lawFirmAwardDao = new LawFirmAwardDaoImpl();
    }

    @Override
    public Award insert(Award award, int lawFirmId) {
        this.lawFirmAwardDao.insert(award,lawFirmId);
        return award;
    }
}
