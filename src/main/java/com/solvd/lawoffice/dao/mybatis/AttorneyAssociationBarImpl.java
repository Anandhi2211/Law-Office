package com.solvd.lawoffice.dao.mybatis;

import com.solvd.lawoffice.dao.AttorneyAssociationBarDao;
import com.solvd.lawoffice.util.dbconfig.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class AttorneyAssociationBarImpl implements AttorneyAssociationBarDao {
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
}
