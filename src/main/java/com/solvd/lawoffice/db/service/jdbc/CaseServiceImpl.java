package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.bin.CaseFiled;
import com.solvd.lawoffice.db.dao.CaseFiledRepository;
import com.solvd.lawoffice.db.service.mybatis.CaseFiledMyBatisImpl;
import com.solvd.lawoffice.db.service.CaseService;

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
