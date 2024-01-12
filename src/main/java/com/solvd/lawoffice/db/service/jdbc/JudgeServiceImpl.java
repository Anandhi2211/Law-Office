package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.binary.Judge;
import com.solvd.lawoffice.db.dao.JudgeDao;
import com.solvd.lawoffice.db.dao.jdbc.JudgeDaoImpl;
import com.solvd.lawoffice.db.service.JudgeService;

public class JudgeServiceImpl implements JudgeService {

    private final JudgeDao judgeDao;

    public JudgeServiceImpl() {
        this.judgeDao = new JudgeDaoImpl();
    }

    @Override
    public Judge insert(Judge judge) {
        this.judgeDao.insert(judge);
        return judge;
    }
}
