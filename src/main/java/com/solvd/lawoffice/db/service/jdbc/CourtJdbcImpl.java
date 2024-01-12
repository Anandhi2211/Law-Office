package com.solvd.lawoffice.db.service.jdbc;
//package com.solvd.law_office.db.service.impl;


import com.solvd.lawoffice.db.binary.Court;
import com.solvd.lawoffice.db.dao.CourtDao;
import com.solvd.lawoffice.db.dao.jdbc.CourtDaoImpl;
import com.solvd.lawoffice.db.service.CourtService;

public class CourtJdbcImpl implements CourtService {

    private final CourtDao courtDao;

    public CourtJdbcImpl() {
        this.courtDao = new CourtDaoImpl();
    }

    @Override
    public Court insert(Court court, int judgeId) {
        this.courtDao.insert(court,judgeId);
        return court;
    }
}
