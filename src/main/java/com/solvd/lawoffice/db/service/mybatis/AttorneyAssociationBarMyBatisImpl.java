package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.dao.AttorneyAssociationBarDao;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class AttorneyAssociationBarMyBatisImpl implements AttorneyAssociationBarDao {
    @Override
    public void insert(int associationBarId, int attorneyId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyAssociationBarDao attorneyAssociationBarDao = sqlSession.getMapper(AttorneyAssociationBarDao.class);
            attorneyAssociationBarDao.insert(associationBarId,attorneyId);
        }

    }
    @Override
    public void deleteByAssociationBarId(int associationBarId) {
            try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
                AttorneyAssociationBarDao attorneyAssociationBarDao = sqlSession.getMapper(AttorneyAssociationBarDao.class);
                attorneyAssociationBarDao.deleteByAssociationBarId(associationBarId);
            }
    }

    @Override
    public void addAssociationBarId(int attorneyId, int associationBarId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyAssociationBarDao attorneyAssociationBarDao = sqlSession.getMapper(AttorneyAssociationBarDao.class);
            attorneyAssociationBarDao.addAssociationBarId(attorneyId,associationBarId);
        }
    }
}
