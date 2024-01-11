package com.solvd.law_office.db.service.mybatis;

import com.solvd.law_office.db.bin.Award;
import com.solvd.law_office.db.util.DaoConfig;
import com.solvd.law_office.db.dao.LawFirmAwardRepository;
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
