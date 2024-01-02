package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.Court;
import com.solvd.law_office.dao.CourtRepository;
import com.solvd.law_office.dao.impl.CourtRepositoryMyBatisImpl;
import com.solvd.law_office.service.CourtService;

public class CourtServiceImpl implements CourtService {

    private final CourtRepository courtRepository;

    public CourtServiceImpl() {
        this.courtRepository = new CourtRepositoryMyBatisImpl();
    }

    @Override
    public Court insert(Court court, int judgeId) {
        this.courtRepository.insert(court,judgeId);
        return court;
    }
}
