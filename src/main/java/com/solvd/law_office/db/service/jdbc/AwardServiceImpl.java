package com.solvd.law_office.db.service.jdbc;

import com.solvd.law_office.db.bin.Award;
import com.solvd.law_office.db.dao.AwardRepository;
import com.solvd.law_office.db.service.mybatis.AwardRepositoryMyBatisImpl;
import com.solvd.law_office.db.service.AwardService;

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
