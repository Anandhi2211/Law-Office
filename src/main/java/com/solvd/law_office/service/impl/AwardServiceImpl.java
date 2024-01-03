package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.Award;
import com.solvd.law_office.dao.AwardRepository;
import com.solvd.law_office.dao.impl.AwardRepositoryMyBatisImpl;
import com.solvd.law_office.service.AwardService;

public class AwardServiceImpl implements AwardService {
    private final AwardRepository awardRepository;

    public AwardServiceImpl() {
        this.awardRepository = new AwardRepositoryMyBatisImpl();
    }

    @Override
    public Award insert(Award award) {
       this.awardRepository.insert(award);
       return award;
    }
}
