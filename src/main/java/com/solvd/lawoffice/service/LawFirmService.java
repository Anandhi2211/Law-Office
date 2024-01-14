package com.solvd.lawoffice.service;

import com.solvd.lawoffice.binary.LawFirm;

import java.util.ArrayList;

public interface LawFirmService {
    LawFirm insert(LawFirm lawFirm);

    ArrayList<LawFirm> findAll();
}
