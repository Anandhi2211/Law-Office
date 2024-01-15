package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.binary.AreaOfPractice;
import com.solvd.lawoffice.dao.AreaOfPracticeDao;
import com.solvd.lawoffice.dao.AttorneyAreaOfPracticeDao;
import com.solvd.lawoffice.service.AreaOfPracticeService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;

public class AreaOfPracticeServiceImpl implements AreaOfPracticeService {

    private final AreaOfPracticeDao areaOfPracticeDao;
    private final AttorneyAreaOfPracticeDao attorneyAreaOfPracticeDao;

    public AreaOfPracticeServiceImpl() {

        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.areaOfPracticeDao = (AreaOfPracticeDao) Class.forName(path + "AreaOfPracticeImpl").getConstructor().newInstance();
            this.attorneyAreaOfPracticeDao = (AttorneyAreaOfPracticeDao) Class.forName(path + "AttorneyAreaOfPracticeImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public AreaOfPractice insert(AreaOfPractice areaOfPractice) {
        this.areaOfPracticeDao.insert(areaOfPractice);
        return areaOfPractice;
    }

    @Override
    public void deleteByAreaOfPracticeId(int areaOfPracticeId) {
        this.attorneyAreaOfPracticeDao.deleteByAreaOfPracticeId(areaOfPracticeId);
        this.areaOfPracticeDao.deleteByAreaOfPracticeId(areaOfPracticeId);
    }
}
