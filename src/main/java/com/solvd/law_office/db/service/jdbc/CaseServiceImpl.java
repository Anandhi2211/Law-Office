package com.solvd.law_office.db.service.jdbc;

import com.solvd.law_office.db.bin.CaseFiled;
import com.solvd.law_office.db.dao.CaseFiledRepository;
import com.solvd.law_office.db.service.mybatis.CaseFiledMyBatisImpl;
import com.solvd.law_office.db.service.CaseService;

public class CaseServiceImpl implements CaseService {
    private final CaseFiledRepository caseFiledRepository;

    public CaseServiceImpl() {
        this.caseFiledRepository = new CaseFiledMyBatisImpl();
    }

    public CaseFiled insert(CaseFiled caseFiled, int clientId) {
        this.caseFiledRepository.insert(caseFiled,clientId);
        return caseFiled;
    }
}
