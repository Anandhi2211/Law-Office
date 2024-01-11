package com.solvd.law_office.db.service;

import com.solvd.law_office.db.bin.BillDetails;

public interface BillDetailsService {
    BillDetails insert(BillDetails billDetails,int clientId);
}
