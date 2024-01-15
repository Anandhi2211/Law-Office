package com.solvd.lawoffice.service;

import com.solvd.lawoffice.binary.Attorney;

import java.util.Optional;

public interface AttorneyService {
    Attorney insert(Attorney attorney, int lawFirmId);

    void deleteAttorneyById(int attorneyId);

    Optional<Attorney> findById(int attorneyId);

    Optional<Attorney> findByName(String name);

    void updateCityById(int i, String city);

    void insertAttorneyAssociationBar(int associationBarId, int attorneyId);
}
