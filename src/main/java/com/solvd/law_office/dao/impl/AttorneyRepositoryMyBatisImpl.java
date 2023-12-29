package com.solvd.law_office.dao.impl;

import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.dao.AttorneyRepository;
import com.solvd.law_office.dao.DaoConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Optional;

public class AttorneyRepositoryMyBatisImpl implements AttorneyRepository {
    @Override
    public void insert(Attorney attorney, int lawFirmId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyRepository attorneyRepository = sqlSession.getMapper(AttorneyRepository.class);
            attorneyRepository.insert(attorney,lawFirmId);
        }
    }

    @Override
    public Optional<Attorney> findById(int attorneyId) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyRepository attorneyRepository = sqlSession.getMapper(AttorneyRepository.class);
            return attorneyRepository.findById(attorneyId);
        }
    }

    @Override
    public Optional<Attorney> findByName(String attorneyName) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyRepository attorneyRepository = sqlSession.getMapper(AttorneyRepository.class);
            return attorneyRepository.findByName(attorneyName);
        }
    }

    @Override
    public void deleteById(int attorney_id) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyRepository attorneyRepository = sqlSession.getMapper(AttorneyRepository.class);
            attorneyRepository.deleteById(attorney_id);
        }

    }

    @Override
    public void updateCityById( int attorney_id,String city) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyRepository attorneyRepository = sqlSession.getMapper(AttorneyRepository.class);
            attorneyRepository.updateCityById( attorney_id, city);
        }

    }

    @Override
    public void addAssociationBar(int attorney_id, int associationBarId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyRepository attorneyRepository = sqlSession.getMapper(AttorneyRepository.class);
//             attorneyRepository.findByName(attorneyName);
        }

    }

    @Override
    public ArrayList<Attorney> findAll() {
        return null;
    }

    @Override
    public ArrayList<Attorney> findByCountry(String country) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            AttorneyRepository attorneyRepository = sqlSession.getMapper(AttorneyRepository.class);
            return attorneyRepository.findByCountry(country);
        }    }
}
