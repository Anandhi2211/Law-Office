package com.solvd.law_office.dao;


import com.solvd.law_office.bin.Attorney;

public interface AttorneyRepository {

    void insert(Attorney attorney, int lawFirmId);
}
