package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.bin.AreaOfPractice;
import com.solvd.lawoffice.db.dao.AreaOfPracticeDao;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class AreaOfPracticeDaoMyBatis implements AreaOfPracticeDao {
    @Override
    public void insert(AreaOfPractice areaOfPractice) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AreaOfPracticeDao areaOfPracticeRepository = sqlSession.getMapper(AreaOfPracticeDao.class);
            areaOfPracticeRepository.insert(areaOfPractice);
        }
    }
}
