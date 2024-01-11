package com.solvd.lawoffice.db.service;

public interface AttorneyAssociationBarService {
    void insert(int associationBarId, int attorneyId);
    void deleteById(int attorneyId);
    void addAssociationBar(int attorneyId, int associationBarId);
}
