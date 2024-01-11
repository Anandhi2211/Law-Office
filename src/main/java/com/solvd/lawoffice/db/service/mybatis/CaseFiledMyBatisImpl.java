package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.binary.CaseFiled;
import com.solvd.lawoffice.db.dao.CaseFiledDao;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class CaseFiledMyBatisImpl implements CaseFiledDao {
    @Override
    public void insert(CaseFiled caseFiled, int clientId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            CaseFiledDao caseFiledDao = sqlSession.getMapper(CaseFiledDao.class);
            caseFiledDao.insert(caseFiled,clientId);
        }
    }
}
