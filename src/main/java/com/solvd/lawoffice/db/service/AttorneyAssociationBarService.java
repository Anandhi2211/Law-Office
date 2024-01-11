package com.solvd.lawoffice.db.service;

import com.solvd.lawoffice.db.bin.Attorney;

public interface AttorneyAssociationBarService {
    Attorney insert(int associationBarId, Attorney attorney);
    void deleteById(int attorneyId);
    void addAssociationBar(int attorneyId, int associationBarId);
}
