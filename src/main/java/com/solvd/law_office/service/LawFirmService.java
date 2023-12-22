package com.solvd.law_office.service;

import com.solvd.law_office.bin.LawFirm;

import java.util.ArrayList;

public interface LawFirmService {
    LawFirm insert(LawFirm lawFirm);

    ArrayList<LawFirm> findAll();
}
