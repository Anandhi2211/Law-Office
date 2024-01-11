package com.solvd.law_office.db.dao;

import com.solvd.law_office.db.bin.CaseFiled;
import org.apache.ibatis.annotations.Param;

public interface CaseFiledRepository {
    void insert(@Param("case") CaseFiled caseFiled,@Param("clientId") int clientId);
}
