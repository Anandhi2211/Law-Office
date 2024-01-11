package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.binary.BillDetails;
import com.solvd.lawoffice.db.dao.BillDetailsDao;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class BillDetailsMyBatisImpl implements BillDetailsDao {
    @Override
    public void insert(BillDetails billDetails,int clientId) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            BillDetailsDao billDetailsDao = sqlSession.getMapper(BillDetailsDao.class);
            billDetailsDao.insert(billDetails,clientId);
        }
    }
}
