package com.solvd.lawoffice.dao.mybatis;

import com.solvd.lawoffice.binary.LawFirm;
import com.solvd.lawoffice.dao.LawFirmDao;
import com.solvd.lawoffice.util.dbconfig.DaoConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class LawFirmImpl implements LawFirmDao {
    @Override
    public void insert(LawFirm lawFirm) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            LawFirmDao lawFirmDao = sqlSession.getMapper(LawFirmDao.class);
            lawFirmDao.insert(lawFirm);
        }
    }

    @Override
    public ArrayList<LawFirm> findAll() {
        return null;
    }
}
