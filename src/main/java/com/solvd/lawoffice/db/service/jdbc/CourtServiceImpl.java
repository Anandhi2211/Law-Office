package com.solvd.lawoffice.db.service.jdbc;
//package com.solvd.law_office.db.service.impl;


import com.solvd.lawoffice.db.binary.Court;
import com.solvd.lawoffice.db.dao.CourtDao;
import com.solvd.lawoffice.db.service.CourtService;
import com.solvd.lawoffice.db.service.mybatis.CourtMyBatisImpl;

public class CourtServiceImpl implements CourtService {

    private final CourtDao courtDao;

    public CourtServiceImpl() {
        this.courtDao = new CourtMyBatisImpl();
    }

    @Override
    public Court insert(Court court, int judgeId) {
        this.courtDao.insert(court,judgeId);
        return court;
    }
}
