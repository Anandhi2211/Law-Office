package com.solvd.lawoffice.service;

import com.solvd.lawoffice.binary.CaseFiled;

public interface CaseService {
    CaseFiled insert(CaseFiled caseFiled, int clientId);
}
