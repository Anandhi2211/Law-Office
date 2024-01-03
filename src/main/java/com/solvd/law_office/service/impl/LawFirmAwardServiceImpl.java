package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.Award;
import com.solvd.law_office.dao.LawFirmAwardRepository;
import com.solvd.law_office.dao.impl.LawFirmAwardRepositoryMyBatisImpl;
import com.solvd.law_office.service.LawFirmAwardService;

public class LawFirmAwardServiceImpl implements LawFirmAwardService {
    private final LawFirmAwardRepository lawFirmAwardRepository;

    public LawFirmAwardServiceImpl() {
        this.lawFirmAwardRepository = new LawFirmAwardRepositoryMyBatisImpl();
    }

    @Override
    public Award insert(Award award, int lawFirmId) {
        this.lawFirmAwardRepository.insert(award,lawFirmId);
        return award;
    }
}
