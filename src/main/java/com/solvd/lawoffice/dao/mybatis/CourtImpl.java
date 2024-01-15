package com.solvd.lawoffice.dao.mybatis;

import com.solvd.lawoffice.binary.Court;
import com.solvd.lawoffice.binary.Judge;
import com.solvd.lawoffice.dao.CourtDao;
import com.solvd.lawoffice.util.dbconfig.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class CourtImpl implements CourtDao {
    @Override
    public void insert(Court court, Judge judgeId) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            CourtDao courtDao = sqlSession.getMapper(CourtDao.class);
            courtDao.insert(court, judgeId);
        }
    }
}
