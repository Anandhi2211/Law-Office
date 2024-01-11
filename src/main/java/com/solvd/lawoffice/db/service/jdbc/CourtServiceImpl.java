package com.solvd.lawoffice.db.service.jdbc;
//package com.solvd.law_office.db.service.impl;


import com.solvd.lawoffice.db.bin.Court;
import com.solvd.lawoffice.db.dao.CourtRepository;
import com.solvd.lawoffice.db.service.CourtService;
import com.solvd.lawoffice.db.service.mybatis.CourtMyBatisImpl;

public class CourtServiceImpl implements CourtService {

    private final CourtRepository courtRepository;

    public CourtServiceImpl() {
        this.courtRepository = new CourtMyBatisImpl();
    }

    @Override
    public Court insert(Court court, int judgeId) {
        this.courtRepository.insert(court,judgeId);
        return court;
    }
}
