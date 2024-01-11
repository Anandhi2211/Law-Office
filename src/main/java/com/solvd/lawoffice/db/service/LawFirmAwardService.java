package com.solvd.lawoffice.db.service;

import com.solvd.lawoffice.db.binary.Award;

public interface LawFirmAwardService {
    Award insert(Award award, int lawFirmId);
}
