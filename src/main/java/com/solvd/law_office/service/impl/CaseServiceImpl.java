package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.CaseFiled;
import com.solvd.law_office.dao.CaseRepository;
import com.solvd.law_office.dao.impl.CaseRepositoryImpl;
import com.solvd.law_office.service.CaseService;

public class CaseServiceImpl implements CaseService {
    private final CaseRepository caseRepository;

    public CaseServiceImpl() {
        this.caseRepository = new CaseRepositoryImpl();
    }

    @Override
    public CaseFiled insert(CaseFiled caseFiled, int lawFirmId) {
        this.caseRepository.insert(caseFiled, lawFirmId);
        return caseFiled;

    }
}
