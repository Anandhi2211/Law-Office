package com.solvd.law_office.dao;

import com.solvd.law_office.bin.CaseFiled;

public interface CaseRepository {
    void insert(CaseFiled caseFiled, int lawFirmId);
}
