package com.solvd.law_office.service;

import com.solvd.law_office.bin.Court;

public interface CourtService {

    Court insert(Court court, int judgeId);
}
