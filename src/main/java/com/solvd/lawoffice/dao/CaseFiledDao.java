package com.solvd.lawoffice.dao;

import com.solvd.lawoffice.binary.CaseFiled;
import org.apache.ibatis.annotations.Param;

public interface CaseFiledDao {
    void insert(@Param("case") CaseFiled caseFiled,@Param("clientId") int clientId);
}
