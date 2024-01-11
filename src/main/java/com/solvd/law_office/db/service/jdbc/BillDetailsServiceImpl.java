package com.solvd.law_office.db.service.jdbc;

import com.solvd.law_office.db.bin.BillDetails;
import com.solvd.law_office.db.dao.BillDetailsRepository;
import com.solvd.law_office.db.service.mybatis.BillDetailsMyBatisImpl;
import com.solvd.law_office.db.service.BillDetailsService;

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
