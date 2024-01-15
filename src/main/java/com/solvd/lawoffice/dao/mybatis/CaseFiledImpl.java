package com.solvd.lawoffice.dao.mybatis;

import com.solvd.lawoffice.binary.CaseFiled;
import com.solvd.lawoffice.dao.CaseFiledDao;
import com.solvd.lawoffice.util.dbconfig.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class CaseFiledImpl implements CaseFiledDao {
    @Override
    public void insert(CaseFiled caseFiled, int clientId) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)) {
            CaseFiledDao caseFiledDao = sqlSession.getMapper(CaseFiledDao.class);
            caseFiledDao.insert(caseFiled, clientId);
        }
    }
}
