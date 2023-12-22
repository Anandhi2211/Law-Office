package com.solvd.law_office.dao;

import com.solvd.law_office.bin.Attorney;

import java.util.ArrayList;

public interface AttorneyRepository {

    void insert(Attorney attorney, int lawFirmId);

    ArrayList<Attorney> findAll();
}
