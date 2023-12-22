package com.solvd.law_office.dao;

import com.solvd.law_office.bin.LawFirm;

import java.util.ArrayList;

public interface LawFirmRepository {
    void insert(LawFirm lawFirm );

    ArrayList<LawFirm> findAll();
}
