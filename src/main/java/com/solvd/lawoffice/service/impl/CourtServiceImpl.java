package com.solvd.lawoffice.service.impl;
//package com.solvd.law_office.db.service.impl;


import com.solvd.lawoffice.binary.Court;
import com.solvd.lawoffice.dao.CourtDao;
import com.solvd.lawoffice.service.CourtService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;

public class CourtServiceImpl implements CourtService {

    private final CourtDao courtDao;

    public CourtServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.courtDao = (CourtDao) Class.forName(path+"CourtImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }    }

    @Override
    public Court insert(Court court, int judgeId) {
        this.courtDao.insert(court,judgeId);
        return court;
    }
}
