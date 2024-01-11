package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.binary.BillDetails;
import org.apache.ibatis.annotations.Param;

public interface BillDetailsDao {
    void insert(@Param("bill") BillDetails billDetails,@Param("clientId") int clientId);
}
