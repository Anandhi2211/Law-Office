package com.solvd.law_office.db.service;

import com.solvd.law_office.db.bin.Court;

public interface CourtService {

    Court insert(Court court, int judgeId);
}
