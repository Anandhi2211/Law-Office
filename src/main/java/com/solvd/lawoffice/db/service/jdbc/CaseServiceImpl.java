package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.binary.CaseFiled;
import com.solvd.lawoffice.db.dao.CaseFiledDao;
import com.solvd.lawoffice.db.service.mybatis.CaseFiledMyBatisImpl;
import com.solvd.lawoffice.db.service.CaseService;

public class CaseServiceImpl implements CaseService {
    private final CaseFiledDao caseFiledDao;

    public CaseServiceImpl() {
        this.caseFiledDao = new CaseFiledMyBatisImpl();
    }

    public CaseFiled insert(CaseFiled caseFiled, int clientId) {
        this.caseFiledDao.insert(caseFiled,clientId);
        return caseFiled;
    }
}
