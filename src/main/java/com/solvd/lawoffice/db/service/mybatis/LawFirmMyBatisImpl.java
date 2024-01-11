package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.bin.LawFirm;
import com.solvd.lawoffice.db.dao.LawFirmRepository;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class LawFirmMyBatisImpl implements LawFirmRepository {
    @Override
    public void insert(LawFirm lawFirm) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            LawFirmRepository lawFirmRepository = sqlSession.getMapper(LawFirmRepository.class);
            lawFirmRepository.insert(lawFirm);
        }
    }
    @Override
    public ArrayList<LawFirm> findAll() {
        return null;
    }
}