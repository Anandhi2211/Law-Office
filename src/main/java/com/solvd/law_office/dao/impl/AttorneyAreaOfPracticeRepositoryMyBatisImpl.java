package com.solvd.law_office.dao.impl;

import com.solvd.law_office.dao.AttorneyAreaOfPracticeRepository;
import com.solvd.law_office.dao.AttorneyAssociationBarRepository;
import com.solvd.law_office.dao.DaoConfig;
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
