package com.solvd.lawoffice.db.service;

import com.solvd.lawoffice.db.bin.Attorney;

import java.util.ArrayList;
import java.util.Optional;

public interface AttorneyService {
    Attorney insert(Attorney attorney, int lawFirmId);
    void deleteById(int attorneyId);
    Optional<Attorney> findById(int attorneyId);
    ArrayList<Attorney> findByCountry(String usa);
    void updateCityById(int i, String city);
    void addAssociationBar(int attorneyId, int associationBarId);
}
