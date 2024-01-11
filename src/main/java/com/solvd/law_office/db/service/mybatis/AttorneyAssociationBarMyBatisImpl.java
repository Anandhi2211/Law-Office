package com.solvd.law_office.db.service.mybatis;

import com.solvd.law_office.db.bin.Attorney;
import com.solvd.law_office.db.dao.AttorneyAssociationBarRepository;
import com.solvd.law_office.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class AttorneyAssociationBarMyBatisImpl implements AttorneyAssociationBarRepository {
    @Override
    public void insert(int associationBarId, Attorney attorney) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyAssociationBarRepository attorneyAssociationBarRepository = sqlSession.getMapper(AttorneyAssociationBarRepository.class);
            attorneyAssociationBarRepository.insert(associationBarId,attorney);
        }

    }
    @Override
    public void deleteByAssociationBarId(int associationBarId) {
            try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
                AttorneyAssociationBarRepository attorneyAssociationBarRepository = sqlSession.getMapper(AttorneyAssociationBarRepository.class);
                attorneyAssociationBarRepository.deleteByAssociationBarId(associationBarId);
            }
    }

    @Override
    public void addAssociationBarId(int attorneyId, int associationBarId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyAssociationBarRepository attorneyAssociationBarRepository = sqlSession.getMapper(AttorneyAssociationBarRepository.class);
            attorneyAssociationBarRepository.addAssociationBarId(attorneyId,associationBarId);
        }
    }
}
