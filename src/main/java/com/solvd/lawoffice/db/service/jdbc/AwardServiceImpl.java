package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.bin.Award;
import com.solvd.lawoffice.db.dao.AwardRepository;
import com.solvd.lawoffice.db.service.mybatis.AwardRepositoryMyBatisImpl;
import com.solvd.lawoffice.db.service.AwardService;

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
