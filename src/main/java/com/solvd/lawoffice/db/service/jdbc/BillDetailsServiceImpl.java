package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.bin.BillDetails;
import com.solvd.lawoffice.db.dao.BillDetailsRepository;
import com.solvd.lawoffice.db.service.mybatis.BillDetailsMyBatisImpl;
import com.solvd.lawoffice.db.service.BillDetailsService;

public class BillDetailsServiceImpl implements BillDetailsService {
    private final BillDetailsRepository billDetailsRepository;

    public BillDetailsServiceImpl() {
        this.billDetailsRepository = new BillDetailsMyBatisImpl();
    }

    @Override
    public BillDetails insert(BillDetails billDetails, int clientId) {
        this.billDetailsRepository.insert(billDetails,clientId);

        return billDetails;
    }
}
