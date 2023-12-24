package com.solvd.law_office.dao;

import com.solvd.law_office.bin.AssociationBar;
import com.solvd.law_office.bin.Attorney;

public interface AttorneyAssociationBarRepository {
    void insert(int associationBarId, Attorney attorney);
}
