package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.binary.BillDetails;
import com.solvd.lawoffice.db.dao.BillDetailsDao;
import com.solvd.lawoffice.db.dao.jdbc.BillDetailsDaoImpl;
import com.solvd.lawoffice.db.service.BillDetailsService;

public class BillDetailsJdbcImpl implements BillDetailsService {
    private final BillDetailsDao billDetailsDao;

    public BillDetailsJdbcImpl() {
        this.billDetailsDao = new BillDetailsDaoImpl();
    }

    @Override
    public BillDetails insert(BillDetails billDetails, int clientId) {
        this.billDetailsDao.insert(billDetails,clientId);

        return billDetails;
    }
}
