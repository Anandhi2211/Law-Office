package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.binary.LawFirm;

import java.util.ArrayList;

public interface LawFirmDao {
    void insert(LawFirm lawFirm);
    ArrayList<LawFirm> findAll();
}
