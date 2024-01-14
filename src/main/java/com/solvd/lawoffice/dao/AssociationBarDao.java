package com.solvd.lawoffice.dao;

import com.solvd.lawoffice.binary.AssociationBar;

public interface AssociationBarDao {
    void insert(AssociationBar associationBar);
    void deleteByAssociationBarId(int associationBarId);
}
