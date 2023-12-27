package com.solvd.law_office.service;

import com.solvd.law_office.bin.Attorney;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface AttorneyService {
    Attorney insert(Attorney attorney, int lawFirmId);
    void deleteById(int attorneyId);
    ArrayList<Attorney> findById(int attorneyId);
    ArrayList<Attorney> findByCountry(String usa);
}
