package com.solvd.lawoffice.dao.mybatis;

import com.solvd.lawoffice.binary.AssociationBar;
import com.solvd.lawoffice.dao.AssociationBarDao;
import com.solvd.lawoffice.dao.AttorneyAssociationBarDao;
import com.solvd.lawoffice.util.dbconfig.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class AssociationBarImpl implements AssociationBarDao {
    @Override
    public void insert(AssociationBar associationBar) {

        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            AssociationBarDao associationBarDao = sqlSession.getMapper(AssociationBarDao.class);
            associationBarDao.insert(associationBar);
        }
    }

    @Override
    public void deleteByAssociationBarId(int associationBarId) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            AttorneyAssociationBarDao attorneyAssociationBarDao = sqlSession.getMapper(AttorneyAssociationBarDao.class);
            attorneyAssociationBarDao.deleteByAssociationBarId(associationBarId);
            AssociationBarDao associationBarDao = sqlSession.getMapper(AssociationBarDao.class);
            associationBarDao.deleteByAssociationBarId(associationBarId);
        }
    }
}
