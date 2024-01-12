package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.binary.Award;
import com.solvd.lawoffice.db.util.DaoConfig;
import com.solvd.lawoffice.db.dao.LawFirmAwardDao;
import org.apache.ibatis.session.SqlSession;

public class LawFirmAwardMyBatisImpl implements LawFirmAwardDao {
    @Override
    public void insert(Award award, int lawFirmId) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            LawFirmAwardDao lawFirmAwardDao = sqlSession.getMapper(LawFirmAwardDao.class);
            lawFirmAwardDao.insert(award,lawFirmId);
        }
    }
}
