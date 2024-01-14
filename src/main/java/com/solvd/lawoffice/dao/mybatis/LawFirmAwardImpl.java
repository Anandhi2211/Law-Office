package com.solvd.lawoffice.dao.mybatis;

import com.solvd.lawoffice.binary.Award;
import com.solvd.lawoffice.util.dbconfig.DaoConfig;
import com.solvd.lawoffice.dao.LawFirmAwardDao;
import org.apache.ibatis.session.SqlSession;

public class LawFirmAwardImpl implements LawFirmAwardDao {
    @Override
    public void insert(Award award, int lawFirmId) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            LawFirmAwardDao lawFirmAwardDao = sqlSession.getMapper(LawFirmAwardDao.class);
            lawFirmAwardDao.insert(award,lawFirmId);
        }
    }
}
