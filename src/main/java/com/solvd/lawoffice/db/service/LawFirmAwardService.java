package com.solvd.lawoffice.db.service;

import com.solvd.lawoffice.db.bin.Award;

public interface LawFirmAwardService {
    Award insert(Award award, int lawFirmId);
}
