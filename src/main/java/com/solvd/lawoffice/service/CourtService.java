package com.solvd.lawoffice.service;

import com.solvd.lawoffice.binary.Court;
import com.solvd.lawoffice.binary.Judge;

public interface CourtService {

    Court insert(Court court, Judge judge);
}
