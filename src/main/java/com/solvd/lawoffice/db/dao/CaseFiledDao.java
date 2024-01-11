package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.binary.CaseFiled;
import org.apache.ibatis.annotations.Param;

public interface CaseFiledDao {
    void insert(@Param("case") CaseFiled caseFiled,@Param("clientId") int clientId);
}
