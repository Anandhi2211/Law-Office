package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.dao.AttorneyAreaOfPracticeDao;
import com.solvd.lawoffice.service.AttorneyAreaOfPracticeService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;

public class AttorneyAreaOfPracticeServiceImpl implements AttorneyAreaOfPracticeService {
    private final AttorneyAreaOfPracticeDao attorneyAreaOfPracticeDao ;
    public AttorneyAreaOfPracticeServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.attorneyAreaOfPracticeDao = (AttorneyAreaOfPracticeDao) Class.forName(path+"AttorneyAreaOfPracticeImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }    }
    @Override
    public void deleteById(int attorneyId) {
        this.attorneyAreaOfPracticeDao.deleteById(attorneyId);
    }
}
