package com.solvd.law_office.dao.impl;

import com.solvd.law_office.bin.Court;
import com.solvd.law_office.dao.CourtRepository;
import com.solvd.law_office.dao.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class CourtRepositoryMyBatisImpl implements CourtRepository {
    @Override
    public void insert(Court court, int judgeId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            CourtRepository courtRepository = sqlSession.getMapper(CourtRepository.class);
            courtRepository.insert(court, judgeId);
        }
    }
}
