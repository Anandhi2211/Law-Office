package com.solvd.law_office.service;

import com.solvd.law_office.bin.Attorney;

public interface AttorneyAssociationBarService {
    Attorney insert(int associationBarId, Attorney attorney);
    void deleteById(int attorneyId);
    void addAssociationBar(int attorneyId, int associationBarId);
}
