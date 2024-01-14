package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.binary.Judge;
import com.solvd.lawoffice.dao.JudgeDao;
import com.solvd.lawoffice.service.JudgeService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;

public class JudgeServiceImpl implements JudgeService {
    private final JudgeDao judgeDao;
    public JudgeServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.judgeDao = (JudgeDao) Class.forName(path+"JudgeImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }    }
    @Override
    public Judge insert(Judge judge) {

        this.judgeDao.insert(judge);
        return judge;
    }
}
