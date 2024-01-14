package com.solvd.lawoffice.dao.mybatis;

import com.solvd.lawoffice.binary.BillDetails;
import com.solvd.lawoffice.dao.BillDetailsDao;
import com.solvd.lawoffice.util.dbconfig.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class BillDetailsImpl implements BillDetailsDao {
    @Override
    public void insert(BillDetails billDetails,int clientId) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            BillDetailsDao billDetailsDao = sqlSession.getMapper(BillDetailsDao.class);
            billDetailsDao.insert(billDetails,clientId);
        }
    }
}
