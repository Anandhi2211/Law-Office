package com.solvd.lawoffice.dao.mybatis;

import com.solvd.lawoffice.binary.Judge;
import com.solvd.lawoffice.dao.JudgeDao;
import com.solvd.lawoffice.util.dbconfig.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class JudgeImpl implements JudgeDao {
    @Override
    public void insert(Judge judge) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            JudgeDao judgeDao = sqlSession.getMapper(JudgeDao.class);
            judgeDao.insert(judge);
        }
    }
}
