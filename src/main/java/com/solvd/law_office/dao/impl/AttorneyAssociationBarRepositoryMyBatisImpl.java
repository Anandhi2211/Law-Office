package com.solvd.law_office.dao.impl;

import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.dao.AssociationBarRepository;
import com.solvd.law_office.dao.AttorneyAssociationBarRepository;
import com.solvd.law_office.dao.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class AttorneyAssociationBarRepositoryMyBatisImpl implements AttorneyAssociationBarRepository {
    @Override
    public void insert(int associationBarId, Attorney attorney) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyAssociationBarRepository attorneyAssociationBarRepository = sqlSession.getMapper(AttorneyAssociationBarRepository.class);
            attorneyAssociationBarRepository.insert(associationBarId,attorney);
        }

    }
    @Override
    public void deleteById(int attorneyId) {
            try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
                AttorneyAssociationBarRepository attorneyAssociationBarRepository = sqlSession.getMapper(AttorneyAssociationBarRepository.class);
                attorneyAssociationBarRepository.deleteById(attorneyId);
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
