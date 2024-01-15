package com.solvd.lawoffice.dao.mybatis;

import com.solvd.lawoffice.binary.Attorney;
import com.solvd.lawoffice.dao.AttorneyDao;
import com.solvd.lawoffice.util.dbconfig.DaoConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Optional;

public class AttorneyImpl implements AttorneyDao {
    @Override
    public void insert(Attorney attorney, int lawFirmId) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            AttorneyDao attorneyDao = sqlSession.getMapper(AttorneyDao.class);
            attorneyDao.insert(attorney, lawFirmId);
        }
    }

    @Override
    public Optional<Attorney> findById(int attorneyId) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            AttorneyDao attorneyDao = sqlSession.getMapper(AttorneyDao.class);
            return attorneyDao.findById(attorneyId);
        }
    }

    @Override
    public Optional<Attorney> findByName(String attorneyName) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            AttorneyDao attorneyDao = sqlSession.getMapper(AttorneyDao.class);
            return attorneyDao.findByName(attorneyName);
        }
    }

    @Override
    public void deleteById(int attorney_id) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            AttorneyDao attorneyDao = sqlSession.getMapper(AttorneyDao.class);
            attorneyDao.deleteById(attorney_id);
        }
    }

    @Override
    public void updateCityById(int attorney_id, String city) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            AttorneyDao attorneyDao = sqlSession.getMapper(AttorneyDao.class);
            attorneyDao.updateCityById(attorney_id, city);
        }
    }

    @Override
    public ArrayList<Attorney> findAll() {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            AttorneyDao attorneyDao = sqlSession.getMapper(AttorneyDao.class);
            return attorneyDao.findAll();
        }
    }
}
