package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.bin.AssociationBar;

public interface AssociationBarDao {
    void insert(AssociationBar associationBar);
    void deleteByAssociationBarId(int associationBarId);
}
