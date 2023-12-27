package com.solvd.law_office.service;

import com.solvd.law_office.bin.Attorney;
import org.apache.ibatis.annotations.Param;

public interface AttorneyService {
    Attorney insert(Attorney attorney, int lawFirmId);
    void deleteById(int attorneyId);
}
