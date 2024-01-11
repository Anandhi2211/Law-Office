package com.solvd.lawoffice.db.service;

import com.solvd.lawoffice.db.binary.CaseFiled;

public interface CaseService {
    CaseFiled insert(CaseFiled caseFiled, int clientId);
}
