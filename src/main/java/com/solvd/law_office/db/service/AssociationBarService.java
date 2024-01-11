package com.solvd.law_office.db.service;

import com.solvd.law_office.db.bin.AssociationBar;

public interface AssociationBarService {
    AssociationBar insert(AssociationBar associationBar);

    void deleteById(int associationBarId);
}
