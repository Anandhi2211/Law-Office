package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.CaseFiled;
import com.solvd.law_office.dao.CaseFiledRepository;
import com.solvd.law_office.dao.impl.CaseFiledRepositoryMybatisImpl;
import com.solvd.law_office.service.CaseService;

public class CaseServiceImpl implements CaseService {
    private final CaseFiledRepository caseFiledRepository;

    public CaseServiceImpl() {
        this.caseFiledRepository = new CaseFiledRepositoryMybatisImpl();
    }

    public CaseFiled insert(CaseFiled caseFiled, int clientId) {
        this.caseFiledRepository.insert(caseFiled,clientId);
        return caseFiled;
    }
}
