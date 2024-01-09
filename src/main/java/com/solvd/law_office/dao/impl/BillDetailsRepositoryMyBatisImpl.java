package com.solvd.law_office.dao.impl;

import com.solvd.law_office.bin.BillDetails;
import com.solvd.law_office.dao.AreaOfPracticeRepository;
import com.solvd.law_office.dao.BillDetailsRepository;
import com.solvd.law_office.dao.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class BillDetailsRepositoryMyBatisImpl implements BillDetailsRepository {
    @Override
    public void insert(BillDetails billDetails,int clientId) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            BillDetailsRepository billDetailsRepository = sqlSession.getMapper(BillDetailsRepository.class);
            billDetailsRepository.insert(billDetails,clientId);
        }
    }
}
