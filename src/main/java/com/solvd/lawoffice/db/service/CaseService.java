package com.solvd.lawoffice.db.service;

import com.solvd.lawoffice.db.bin.CaseFiled;

public interface CaseService {
    CaseFiled insert(CaseFiled caseFiled, int clientId);
}
