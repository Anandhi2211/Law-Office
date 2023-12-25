package com.solvd.law_office.dao.impl;

import com.solvd.law_office.bin.LawFirm;
import com.solvd.law_office.dao.AssociationBarRepository;
import com.solvd.law_office.dao.DaoConfig;
import com.solvd.law_office.dao.LawFirmRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;

public class LawFirmRepositoryMyBatisImpl implements LawFirmRepository {
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
