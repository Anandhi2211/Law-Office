package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.Judge;
import com.solvd.law_office.dao.JudgeRepository;
import com.solvd.law_office.dao.impl.JudgeRepositoryMyBatisImpl;
import com.solvd.law_office.service.JudgeService;

public class JudgeServiceImpl implements JudgeService {

    private final JudgeRepository judgeRepository;

    public JudgeServiceImpl() {
        this.judgeRepository = new JudgeRepositoryMyBatisImpl();
    }

    @Override
    public Judge insert(Judge judge) {
        this.judgeRepository.insert(judge);
        return judge;
    }
}
