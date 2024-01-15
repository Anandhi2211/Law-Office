package com.solvd.lawoffice.service.impl;
//package com.solvd.law_office.db.service.impl;


import com.solvd.lawoffice.binary.CaseFiled;
import com.solvd.lawoffice.binary.Court;
import com.solvd.lawoffice.binary.Judge;
import com.solvd.lawoffice.dao.CourtDao;
import com.solvd.lawoffice.dao.JudgeDao;
import com.solvd.lawoffice.service.CaseService;
import com.solvd.lawoffice.service.CourtService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class CourtServiceImpl implements CourtService {

    private final CourtDao courtDao;

    private final CaseService caseService;

    private final JudgeDao judgeDao;

    public CourtServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.courtDao = (CourtDao) Class.forName(path + "CourtImpl").getConstructor().newInstance();
            this.judgeDao = (JudgeDao) Class.forName(path + "JudgeImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.caseService = new CaseFiledServiceImpl();
    }

    public Court insert(Court court, Judge judge) {
        this.judgeDao.insert(judge);
        this.courtDao.insert(court, judge);
        ArrayList<CaseFiled> caseFiledList = court.getCaseFiledList();
        for (CaseFiled caseFiled : caseFiledList) {
            this.caseService.insert(caseFiled, caseFiled.getClientId());
        }
        return court;
    }
}
