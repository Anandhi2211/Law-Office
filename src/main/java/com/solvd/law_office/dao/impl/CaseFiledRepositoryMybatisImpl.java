package com.solvd.law_office.dao.impl;

import com.solvd.law_office.bin.CaseFiled;
import com.solvd.law_office.dao.AttorneyAssociationBarRepository;
import com.solvd.law_office.dao.CaseFiledRepository;
import com.solvd.law_office.dao.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class CaseFiledRepositoryMybatisImpl implements CaseFiledRepository {
    @Override
    public void insert(CaseFiled caseFiled) {
        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            CaseFiledRepository caseFiledRepository = sqlSession.getMapper(CaseFiledRepository.class);
            caseFiledRepository.insert(caseFiled);
        }
    }
}
