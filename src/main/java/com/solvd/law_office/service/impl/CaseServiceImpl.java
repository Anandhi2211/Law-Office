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


    @Override
    public CaseFiled insert(CaseFiled caseFiled) {
        this.caseFiledRepository.insert(caseFiled);
        return caseFiled;
    }
}
