package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.dao.AttorneyAreaOfPracticeRepository;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class AttorneyAreaOfPracticeRepositoryMyBatisImpl implements AttorneyAreaOfPracticeRepository {
    @Override
    public void deleteById(int attorneyId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyAreaOfPracticeRepository attorneyAreaOfPracticeRepository = sqlSession.getMapper(AttorneyAreaOfPracticeRepository.class);
            attorneyAreaOfPracticeRepository.deleteById(attorneyId);
        }

    }
}
