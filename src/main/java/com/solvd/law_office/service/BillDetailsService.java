package com.solvd.law_office.service;

import com.solvd.law_office.bin.BillDetails;

public interface BillDetailsService {
    BillDetails insert(BillDetails billDetails,int clientId);
}
