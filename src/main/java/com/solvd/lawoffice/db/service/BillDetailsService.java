package com.solvd.lawoffice.db.service;

import com.solvd.lawoffice.db.binary.BillDetails;

public interface BillDetailsService {
    BillDetails insert(BillDetails billDetails,int clientId);
}
