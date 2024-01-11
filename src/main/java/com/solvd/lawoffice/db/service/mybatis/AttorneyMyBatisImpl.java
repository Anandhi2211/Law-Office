package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.binary.Attorney;
import com.solvd.lawoffice.db.dao.AttorneyDao;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Optional;

public class AttorneyMyBatisImpl implements AttorneyDao {
    @Override
    public void insert(Attorney attorney, int lawFirmId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyDao attorneyDao = sqlSession.getMapper(AttorneyDao.class);
            attorneyDao.insert(attorney,lawFirmId);
        }
    }

    @Override
    public Optional<Attorney> findById(int attorneyId) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyDao attorneyDao = sqlSession.getMapper(AttorneyDao.class);
            return attorneyDao.findById(attorneyId);
        }
    }

    @Override
    public Optional<Attorney> findByName(String attorneyName) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyDao attorneyDao = sqlSession.getMapper(AttorneyDao.class);
            return attorneyDao.findByName(attorneyName);
        }
    }

    @Override
    public void deleteById(int attorney_id) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyDao attorneyDao = sqlSession.getMapper(AttorneyDao.class);
            attorneyDao.deleteById(attorney_id);
        }

    }

    @Override
    public void updateCityById( int attorney_id,String city) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyDao attorneyDao = sqlSession.getMapper(AttorneyDao.class);
            attorneyDao.updateCityById( attorney_id, city);
        }

    }

    @Override
    public void addAssociationBar(int attorney_id, int associationBarId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyDao attorneyDao = sqlSession.getMapper(AttorneyDao.class);
//             attorneyDao.findByName(attorneyName);
        }

    }

    @Override
    public ArrayList<Attorney> findAll() {
        return null;
    }

}
