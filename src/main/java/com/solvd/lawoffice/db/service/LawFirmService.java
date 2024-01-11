package com.solvd.lawoffice.db.service;

import com.solvd.lawoffice.db.binary.LawFirm;

import java.util.ArrayList;

public interface LawFirmService {
    LawFirm insert(LawFirm lawFirm);

    ArrayList<LawFirm> findAll();
}
