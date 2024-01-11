package com.solvd.lawoffice.db.service;

import com.solvd.lawoffice.db.bin.AssociationBar;

public interface AssociationBarService {
    AssociationBar insert(AssociationBar associationBar);

    void deleteById(int associationBarId);
}
