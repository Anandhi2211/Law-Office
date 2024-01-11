package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.binary.BillDetails;
import com.solvd.lawoffice.db.dao.BillDetailsDao;
import com.solvd.lawoffice.db.service.mybatis.BillDetailsMyBatisImpl;
import com.solvd.lawoffice.db.service.BillDetailsService;

public class BillDetailsServiceImpl implements BillDetailsService {
    private final BillDetailsDao billDetailsDao;

    public BillDetailsServiceImpl() {
        this.billDetailsDao = new BillDetailsMyBatisImpl();
    }

    @Override
    public BillDetails insert(BillDetails billDetails, int clientId) {
        this.billDetailsDao.insert(billDetails,clientId);

        return billDetails;
    }
}
