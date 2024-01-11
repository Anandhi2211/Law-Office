package com.solvd.law_office.db.service;

import com.solvd.law_office.db.bin.Award;

public interface LawFirmAwardService {
    Award insert(Award award, int lawFirmId);
}
