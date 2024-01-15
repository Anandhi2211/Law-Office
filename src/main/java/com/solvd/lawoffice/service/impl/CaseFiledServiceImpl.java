package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.binary.CaseFiled;
import com.solvd.lawoffice.dao.CaseFiledDao;
import com.solvd.lawoffice.service.CaseService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;

public class CaseFiledServiceImpl implements CaseService {
    private final CaseFiledDao caseFiledDao;

    public CaseFiledServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.caseFiledDao = (CaseFiledDao) Class.forName(path + "CaseFiledImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public CaseFiled insert(CaseFiled caseFiled, int clientId) {
        this.caseFiledDao.insert(caseFiled, clientId);
        return caseFiled;
    }
}
