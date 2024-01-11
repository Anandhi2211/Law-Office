package com.solvd.law_office.db.service.mybatis;

import com.solvd.law_office.db.bin.AreaOfPractice;
import com.solvd.law_office.db.dao.AreaOfPracticeRepository;
import com.solvd.law_office.db.util.DaoConfig;
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
