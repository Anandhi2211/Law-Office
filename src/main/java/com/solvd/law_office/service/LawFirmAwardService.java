package com.solvd.law_office.service;

import com.solvd.law_office.bin.Award;
import com.solvd.law_office.bin.LawFirm;

public interface LawFirmAwardService {
    Award insert(Award award, int lawFirmId);
}
