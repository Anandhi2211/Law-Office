package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.bin.BillDetails;
import org.apache.ibatis.annotations.Param;

public interface BillDetailsRepository {
    void insert(@Param("bill") BillDetails billDetails,@Param("clientId") int clientId);
}
