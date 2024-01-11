package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.bin.AssociationBar;
import com.solvd.lawoffice.db.dao.AssociationBarRepository;
import com.solvd.lawoffice.db.dao.AttorneyAssociationBarRepository;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class AssociationBarMyBatisImpl implements AssociationBarRepository {
    @Override
    public void insert(AssociationBar associationBar) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AssociationBarRepository associationBarRepository = sqlSession.getMapper(AssociationBarRepository.class);
            associationBarRepository.insert(associationBar);
        }
    }

    @Override
    public void deleteByAssociationBarId(int associationBarId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyAssociationBarRepository attorneyAssociationBarRepository = sqlSession.getMapper(AttorneyAssociationBarRepository.class);
            attorneyAssociationBarRepository.deleteByAssociationBarId(associationBarId);
            AssociationBarRepository associationBarRepository = sqlSession.getMapper(AssociationBarRepository.class);
            associationBarRepository.deleteByAssociationBarId(associationBarId);
        }
    }
}
