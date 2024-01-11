package com.solvd.law_office.db.service.mybatis;

import com.solvd.law_office.db.bin.BillDetails;
import com.solvd.law_office.db.dao.BillDetailsRepository;
import com.solvd.law_office.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class BillDetailsMyBatisImpl implements BillDetailsRepository {
    @Override
    public void insert(BillDetails billDetails,int clientId) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            BillDetailsRepository billDetailsRepository = sqlSession.getMapper(BillDetailsRepository.class);
            billDetailsRepository.insert(billDetails,clientId);
        }
    }
}
