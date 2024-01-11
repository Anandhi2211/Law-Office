package com.solvd.law_office.db.service.mybatis;

import com.solvd.law_office.db.bin.Judge;
import com.solvd.law_office.db.util.DaoConfig;
import com.solvd.law_office.db.dao.JudgeRepository;
import org.apache.ibatis.session.SqlSession;

public class JudgeMyBatisImpl implements JudgeRepository {
    @Override
    public void insert(Judge judge) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            JudgeRepository judgeRepository = sqlSession.getMapper(JudgeRepository.class);
            judgeRepository.insert(judge);
        }
    }
}
