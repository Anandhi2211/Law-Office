package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.bin.Judge;
import com.solvd.lawoffice.db.dao.JudgeDao;
import com.solvd.lawoffice.db.service.JudgeService;
import com.solvd.lawoffice.db.service.mybatis.JudgeMyBatisImpl;

public class JudgeServiceImpl implements JudgeService {

    private final JudgeDao judgeDao;

    public JudgeServiceImpl() {
        this.judgeDao = new JudgeMyBatisImpl();
    }

    @Override
    public Judge insert(Judge judge) {
        this.judgeDao.insert(judge);
        return judge;
    }
}
