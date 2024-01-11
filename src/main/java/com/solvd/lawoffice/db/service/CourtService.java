package com.solvd.lawoffice.db.service;

import com.solvd.lawoffice.db.binary.Court;

public interface CourtService {

    Court insert(Court court, int judgeId);
}
