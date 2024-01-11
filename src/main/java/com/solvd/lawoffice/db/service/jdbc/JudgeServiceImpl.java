package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.bin.Judge;
import com.solvd.lawoffice.db.dao.JudgeRepository;
import com.solvd.lawoffice.db.service.JudgeService;
import com.solvd.lawoffice.db.service.mybatis.JudgeMyBatisImpl;

public class JudgeServiceImpl implements JudgeService {

    private final JudgeRepository judgeRepository;

    public JudgeServiceImpl() {
        this.judgeRepository = new JudgeMyBatisImpl();
    }

    @Override
    public Judge insert(Judge judge) {
        this.judgeRepository.insert(judge);
        return judge;
    }
}
