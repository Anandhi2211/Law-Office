package com.solvd.lawoffice.service;

import com.solvd.lawoffice.binary.Court;

public interface CourtService {

    Court insert(Court court, int judgeId);
}
