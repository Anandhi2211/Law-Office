package com.solvd.law_office.db.service.mybatis;

import com.solvd.law_office.db.bin.CaseFiled;
import com.solvd.law_office.db.dao.CaseFiledRepository;
import com.solvd.law_office.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class CaseFiledMyBatisImpl implements CaseFiledRepository {
    @Override
    public void insert(CaseFiled caseFiled, int clientId) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            CaseFiledRepository caseFiledRepository = sqlSession.getMapper(CaseFiledRepository.class);
            caseFiledRepository.insert(caseFiled,clientId);
        }
    }
}
