package com.solvd.law_office.dao.impl;

import com.solvd.law_office.bin.AreaOfPractice;
import com.solvd.law_office.dao.AreaOfPracticeRepository;
import com.solvd.law_office.dao.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class AreaOfPracticeRepositoryMyBatis implements AreaOfPracticeRepository {
    @Override
    public void insert(AreaOfPractice areaOfPractice) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AreaOfPracticeRepository areaOfPracticeRepository = sqlSession.getMapper(AreaOfPracticeRepository.class);
            areaOfPracticeRepository.insert(areaOfPractice);
        }
    }
}
