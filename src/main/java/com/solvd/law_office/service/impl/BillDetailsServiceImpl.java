package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.BillDetails;
import com.solvd.law_office.dao.BillDetailsRepository;
import com.solvd.law_office.dao.impl.BillDetailsRepositoryMyBatisImpl;
import com.solvd.law_office.service.BillDetailsService;

public class BillDetailsServiceImpl implements BillDetailsService {
    private final BillDetailsRepository billDetailsRepository;

    public BillDetailsServiceImpl() {
        this.billDetailsRepository = new BillDetailsRepositoryMyBatisImpl();
    }

    @Override
    public BillDetails insert(BillDetails billDetails, int clientId) {
        this.billDetailsRepository.insert(billDetails,clientId);

        return billDetails;
    }
}
