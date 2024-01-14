package com.solvd.lawoffice.service;

public interface AttorneyAssociationBarService {
    void insert(int associationBarId, int attorneyId);
    void deleteById(int attorneyId);
}
