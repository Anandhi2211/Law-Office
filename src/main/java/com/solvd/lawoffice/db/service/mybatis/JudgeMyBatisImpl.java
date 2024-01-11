package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.binary.Judge;
import com.solvd.lawoffice.db.dao.JudgeDao;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class JudgeMyBatisImpl implements JudgeDao {
    @Override
    public void insert(Judge judge) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            JudgeDao judgeDao = sqlSession.getMapper(JudgeDao.class);
            judgeDao.insert(judge);
        }
    }
}
