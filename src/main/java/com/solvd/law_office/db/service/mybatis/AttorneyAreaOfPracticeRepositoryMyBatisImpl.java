package com.solvd.law_office.db.service.mybatis;

import com.solvd.law_office.db.dao.AttorneyAreaOfPracticeRepository;
import com.solvd.law_office.db.util.DaoConfig;
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
