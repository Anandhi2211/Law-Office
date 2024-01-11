package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.binary.AssociationBar;
import com.solvd.lawoffice.db.dao.AssociationBarDao;
import com.solvd.lawoffice.db.dao.AttorneyAssociationBarDao;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class AssociationBarMyBatisImpl implements AssociationBarDao {
    @Override
    public void insert(AssociationBar associationBar) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AssociationBarDao associationBarDao = sqlSession.getMapper(AssociationBarDao.class);
            associationBarDao.insert(associationBar);
        }
    }

    @Override
    public void deleteByAssociationBarId(int associationBarId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyAssociationBarDao attorneyAssociationBarDao = sqlSession.getMapper(AttorneyAssociationBarDao.class);
            attorneyAssociationBarDao.deleteByAssociationBarId(associationBarId);
            AssociationBarDao associationBarDao = sqlSession.getMapper(AssociationBarDao.class);
            associationBarDao.deleteByAssociationBarId(associationBarId);
        }
    }
}
