package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.binary.AssociationBar;

public interface AssociationBarDao {
    void insert(AssociationBar associationBar);
    void deleteByAssociationBarId(int associationBarId);
}
