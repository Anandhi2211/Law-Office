package com.solvd.lawoffice.service;

import com.solvd.lawoffice.binary.AssociationBar;

public interface AssociationBarService {
    AssociationBar insert(AssociationBar associationBar);

    void deleteByAssociationBarId(int associationBarId);
}
