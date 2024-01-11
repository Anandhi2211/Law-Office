package com.solvd.law_office.db.dao;

import com.solvd.law_office.db.bin.AssociationBar;

public interface AssociationBarRepository {
    void insert(AssociationBar associationBar);
    void deleteByAssociationBarId(int associationBarId);
}
