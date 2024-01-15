package com.solvd.lawoffice.service;

import com.solvd.lawoffice.binary.AreaOfPractice;

public interface AreaOfPracticeService {
    AreaOfPractice insert(AreaOfPractice areaOfPractice);

    void deleteByAreaOfPracticeId(int areaOfPracticeId);
}

