package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.binary.Award;
import com.solvd.lawoffice.dao.AwardDao;
import com.solvd.lawoffice.service.AwardService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;

public class AwardServiceImpl implements AwardService {
    private final AwardDao awardDao;

    public AwardServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.awardDao = (AwardDao) Class.forName(path+"AwardImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }    }

    @Override
    public Award insert(Award award) {
       this.awardDao.insert(award);
       return award;
    }
}
