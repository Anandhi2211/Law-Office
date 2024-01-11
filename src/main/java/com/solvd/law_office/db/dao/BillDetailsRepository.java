package com.solvd.law_office.db.dao;

import com.solvd.law_office.db.bin.BillDetails;
import org.apache.ibatis.annotations.Param;

public interface BillDetailsRepository {
    void insert(@Param("bill") BillDetails billDetails,@Param("clientId") int clientId);
}
