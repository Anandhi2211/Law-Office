package com.solvd.law_office.db.service.jdbc;

import com.solvd.law_office.db.bin.Award;
import com.solvd.law_office.db.dao.LawFirmAwardRepository;
import com.solvd.law_office.db.dao.jdbc.LawFirmAwardDaoImpl;
import com.solvd.law_office.db.service.LawFirmAwardService;

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
