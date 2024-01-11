package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.bin.BillDetails;
import com.solvd.lawoffice.db.dao.BillDetailsRepository;
import com.solvd.lawoffice.db.util.DaoConfig;
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
