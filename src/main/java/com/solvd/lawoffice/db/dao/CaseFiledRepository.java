package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.bin.CaseFiled;
import org.apache.ibatis.annotations.Param;

public interface CaseFiledRepository {
    void insert(@Param("case") CaseFiled caseFiled,@Param("clientId") int clientId);
}
