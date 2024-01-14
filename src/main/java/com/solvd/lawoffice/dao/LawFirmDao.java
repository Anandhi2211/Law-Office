package com.solvd.lawoffice.dao;

import com.solvd.lawoffice.binary.LawFirm;

import java.util.ArrayList;

public interface LawFirmDao {
    void insert(LawFirm lawFirm);
    ArrayList<LawFirm> findAll();
}
