package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.bin.Judge;
import com.solvd.lawoffice.db.util.DaoConfig;
import com.solvd.lawoffice.db.dao.JudgeRepository;
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
