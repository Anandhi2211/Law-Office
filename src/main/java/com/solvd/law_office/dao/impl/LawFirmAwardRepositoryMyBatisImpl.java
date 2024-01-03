package com.solvd.law_office.dao.impl;

import com.solvd.law_office.bin.Award;
import com.solvd.law_office.dao.AttorneyAssociationBarRepository;
import com.solvd.law_office.dao.DaoConfig;
import com.solvd.law_office.dao.LawFirmAwardRepository;
import org.apache.ibatis.session.SqlSession;

public class LawFirmAwardRepositoryMyBatisImpl implements LawFirmAwardRepository {
    @Override
    public void insert(Award award, int lawFirmId) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            LawFirmAwardRepository lawFirmAwardRepository = sqlSession.getMapper(LawFirmAwardRepository.class);
            lawFirmAwardRepository.insert(award,lawFirmId);
        }
    }
}
