package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.binary.Award;
import com.solvd.lawoffice.db.dao.AwardDao;
import com.solvd.lawoffice.db.service.mybatis.AwardDaoMyBatisImpl;
import com.solvd.lawoffice.db.service.AwardService;

public class AwardServiceImpl implements AwardService {
    private final AwardDao awardDao;

    public AwardServiceImpl() {
        this.awardDao = new AwardDaoMyBatisImpl();
    }

    @Override
    public Award insert(Award award) {
       this.awardDao.insert(award);
       return award;
    }
}
