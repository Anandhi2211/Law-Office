package com.solvd.law_office.dao.impl;

import com.solvd.law_office.bin.AssociationBar;
import com.solvd.law_office.dao.AssociationBarRepository;
import com.solvd.law_office.dao.AttorneyAssociationBarRepository;
import com.solvd.law_office.dao.AttorneyRepository;
import com.solvd.law_office.dao.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class AssociationBarRepositoryMyBatisImpl implements AssociationBarRepository {
    @Override
    public void insert(AssociationBar associationBar) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AssociationBarRepository associationBarRepository = sqlSession.getMapper(AssociationBarRepository.class);
            associationBarRepository.insert(associationBar);
        }
    }

    @Override
    public void deleteById(int associationBarId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AssociationBarRepository associationBarRepository = sqlSession.getMapper(AssociationBarRepository.class);
            associationBarRepository.deleteById(associationBarId);
        }
    }
}
