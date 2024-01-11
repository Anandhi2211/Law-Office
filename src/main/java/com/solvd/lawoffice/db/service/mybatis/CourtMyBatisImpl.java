package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.bin.Court;
import com.solvd.lawoffice.db.dao.CourtRepository;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class CourtMyBatisImpl implements CourtRepository {
    @Override
    public void insert(Court court, int judgeId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            CourtRepository courtRepository = sqlSession.getMapper(CourtRepository.class);
            courtRepository.insert(court, judgeId);
        }
    }
}
