package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.dao.AttorneyAreaOfPracticeDao;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class AttorneyAreaOfPracticeDaoMyBatisImpl implements AttorneyAreaOfPracticeDao {
    @Override
    public void deleteById(int attorneyId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyAreaOfPracticeDao attorneyAreaOfPracticeDao = sqlSession.getMapper(AttorneyAreaOfPracticeDao.class);
            attorneyAreaOfPracticeDao.deleteById(attorneyId);
        }

    }
}
