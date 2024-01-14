package com.solvd.lawoffice.service;

import com.solvd.lawoffice.binary.Award;

public interface LawFirmAwardService {
    Award insert(Award award, int lawFirmId);
}
