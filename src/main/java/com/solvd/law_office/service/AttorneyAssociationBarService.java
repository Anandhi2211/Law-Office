package com.solvd.law_office.service;

import com.solvd.law_office.bin.Attorney;

public interface AttorneyAssociationBarService {
    Attorney insert(int associationBar, Attorney attorney);
}