package com.solvd.lawoffice.dao.mybatis;

import com.solvd.lawoffice.dao.AttorneyAreaOfPracticeDao;
import com.solvd.lawoffice.util.dbconfig.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class AttorneyAreaOfPracticeImpl implements AttorneyAreaOfPracticeDao {
    @Override
    public void deleteByAreaOfPracticeId(int areaOfPracticeId) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            AttorneyAreaOfPracticeDao attorneyAreaOfPracticeDao = sqlSession.getMapper(AttorneyAreaOfPracticeDao.class);
            attorneyAreaOfPracticeDao.deleteByAreaOfPracticeId(areaOfPracticeId);
        }
    }

    @Override
    public void deleteAttorneyById(int attorneyId) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            AttorneyAreaOfPracticeDao attorneyAreaOfPracticeDao = sqlSession.getMapper(AttorneyAreaOfPracticeDao.class);
            attorneyAreaOfPracticeDao.deleteAttorneyById(attorneyId);
        }
    }
}
