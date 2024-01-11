package com.solvd.law_office.db.service;

import com.solvd.law_office.db.bin.CaseFiled;

public interface CaseService {
    CaseFiled insert(CaseFiled caseFiled, int clientId);
}
