package com.solvd.law_office.db.service.jdbc;

import com.solvd.law_office.db.bin.Judge;
import com.solvd.law_office.db.dao.JudgeRepository;
import com.solvd.law_office.db.service.JudgeService;
import com.solvd.law_office.db.service.mybatis.JudgeMyBatisImpl;

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
