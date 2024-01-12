package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.binary.CaseFiled;
import com.solvd.lawoffice.db.dao.CaseFiledDao;
import com.solvd.lawoffice.db.dao.jdbc.CaseFiledDaoImpl;
import com.solvd.lawoffice.db.service.CaseService;

public class CaseFiledJdbcImpl implements CaseService {
    private final CaseFiledDao caseFiledDao;

    public CaseFiledJdbcImpl() {
        this.caseFiledDao = new CaseFiledDaoImpl();
    }

    public CaseFiled insert(CaseFiled caseFiled, int clientId) {
        this.caseFiledDao.insert(caseFiled,clientId);
        return caseFiled;
    }
}
