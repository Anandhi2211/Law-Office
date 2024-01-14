package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.binary.BillDetails;
import com.solvd.lawoffice.dao.BillDetailsDao;
import com.solvd.lawoffice.service.BillDetailsService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;

public class BillDetailsServiceImpl implements BillDetailsService {
    private final BillDetailsDao billDetailsDao;

    public BillDetailsServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.billDetailsDao = (BillDetailsDao) Class.forName(path+"BillDetailsImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }    }

    @Override
    public BillDetails insert(BillDetails billDetails, int clientId) {
        this.billDetailsDao.insert(billDetails,clientId);

        return billDetails;
    }
}
