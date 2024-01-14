package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.binary.AreaOfPractice;
import com.solvd.lawoffice.dao.AreaOfPracticeDao;
import com.solvd.lawoffice.service.AreaOfPracticeService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;

public class AreaOfPracticeServiceImpl implements AreaOfPracticeService {

    private final AreaOfPracticeDao areaOfPracticeDao;

    public AreaOfPracticeServiceImpl() {

        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.areaOfPracticeDao = (AreaOfPracticeDao) Class.forName(path+"AreaOfPracticeImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

//        this.areaOfPracticeDao = new AreaOfPracticeImpl();
    }

    public AreaOfPractice insert(AreaOfPractice areaOfPractice) {
        this.areaOfPracticeDao.insert(areaOfPractice);
                return areaOfPractice;
    }
}
