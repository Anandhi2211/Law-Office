package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.bin.LawFirm;

import java.util.ArrayList;

public interface LawFirmRepository {
    void insert(LawFirm lawFirm);

    ArrayList<LawFirm> findAll();
}
