package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.binary.Court;
import com.solvd.lawoffice.db.dao.CourtDao;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class CourtMyBatisImpl implements CourtDao {
    @Override
    public void insert(Court court, int judgeId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            CourtDao courtDao = sqlSession.getMapper(CourtDao.class);
            courtDao.insert(court, judgeId);
        }
    }
}
