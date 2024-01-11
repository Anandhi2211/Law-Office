package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.bin.AreaOfPractice;
import com.solvd.lawoffice.db.dao.AreaOfPracticeRepository;
import com.solvd.lawoffice.db.util.DaoConfig;
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
