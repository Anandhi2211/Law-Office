package com.solvd.law_office.db.service;

import com.solvd.law_office.db.bin.LawFirm;

import java.util.ArrayList;

public interface LawFirmService {
    LawFirm insert(LawFirm lawFirm);

    ArrayList<LawFirm> findAll();
}
