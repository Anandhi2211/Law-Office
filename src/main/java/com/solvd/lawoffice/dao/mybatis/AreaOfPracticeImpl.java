package com.solvd.lawoffice.dao.mybatis;

import com.solvd.lawoffice.binary.AreaOfPractice;
import com.solvd.lawoffice.dao.AreaOfPracticeDao;
import com.solvd.lawoffice.util.dbconfig.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class AreaOfPracticeImpl implements AreaOfPracticeDao {
    @Override
    public void insert(AreaOfPractice areaOfPractice) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            AreaOfPracticeDao areaOfPracticeRepository = sqlSession.getMapper(AreaOfPracticeDao.class);
            areaOfPracticeRepository.insert(areaOfPractice);
        }
    }

    @Override
    public void deleteByAreaOfPracticeId(int areaOfPracticeId) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            AreaOfPracticeDao areaOfPracticeRepository = sqlSession.getMapper(AreaOfPracticeDao.class);
            areaOfPracticeRepository.deleteByAreaOfPracticeId(areaOfPracticeId);
        }
    }
}
