package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.binary.Award;
import com.solvd.lawoffice.dao.LawFirmAwardDao;
import com.solvd.lawoffice.service.LawFirmAwardService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;

public class LawFirmAwardServiceImpl implements LawFirmAwardService {
    private final LawFirmAwardDao lawFirmAwardDao;
    public LawFirmAwardServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.lawFirmAwardDao = (LawFirmAwardDao) Class.forName(path+"LawFirmAwardImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }    }
    @Override
    public Award insert(Award award, int lawFirmId) {
        this.lawFirmAwardDao.insert(award,lawFirmId);
        return award;
    }
}
