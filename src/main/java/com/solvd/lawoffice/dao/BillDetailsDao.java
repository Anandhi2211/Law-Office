package com.solvd.lawoffice.dao;

import com.solvd.lawoffice.binary.BillDetails;
import org.apache.ibatis.annotations.Param;

public interface BillDetailsDao {
    void insert(@Param("bill") BillDetails billDetails,@Param("clientId") int clientId);
}
