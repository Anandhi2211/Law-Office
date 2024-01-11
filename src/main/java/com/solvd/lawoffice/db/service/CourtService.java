package com.solvd.lawoffice.db.service;

import com.solvd.lawoffice.db.bin.Court;

public interface CourtService {

    Court insert(Court court, int judgeId);
}
