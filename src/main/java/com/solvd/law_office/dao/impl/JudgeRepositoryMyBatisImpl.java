package com.solvd.law_office.dao.impl;

import com.solvd.law_office.bin.Judge;
import com.solvd.law_office.dao.AreaOfPracticeRepository;
import com.solvd.law_office.dao.DaoConfig;
import com.solvd.law_office.dao.JudgeRepository;
import org.apache.ibatis.session.SqlSession;

public class JudgeRepositoryMyBatisImpl implements JudgeRepository {
    @Override
    public void insert(Judge judge) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            JudgeRepository judgeRepository = sqlSession.getMapper(JudgeRepository.class);
            judgeRepository.insert(judge);
        }
    }
}
