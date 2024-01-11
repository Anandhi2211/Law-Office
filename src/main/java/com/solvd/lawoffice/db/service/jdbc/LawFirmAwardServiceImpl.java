package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.bin.Award;
import com.solvd.lawoffice.db.dao.LawFirmAwardRepository;
import com.solvd.lawoffice.db.dao.jdbc.LawFirmAwardDaoImpl;
import com.solvd.lawoffice.db.service.LawFirmAwardService;

public class LawFirmAwardServiceImpl implements LawFirmAwardService {
    private final LawFirmAwardRepository lawFirmAwardRepository;

    public LawFirmAwardServiceImpl() {
        this.lawFirmAwardRepository = new LawFirmAwardDaoImpl();
    }

    @Override
    public Award insert(Award award, int lawFirmId) {
        this.lawFirmAwardRepository.insert(award,lawFirmId);
        return award;
    }
}
