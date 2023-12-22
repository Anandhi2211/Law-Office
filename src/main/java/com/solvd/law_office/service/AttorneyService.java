package com.solvd.law_office.service;

import com.solvd.law_office.bin.Attorney;

public interface AttorneyService {
    Attorney insert(Attorney attorney, int lawFirmId);
}
