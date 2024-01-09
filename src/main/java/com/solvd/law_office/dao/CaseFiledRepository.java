package com.solvd.law_office.dao;

import com.solvd.law_office.bin.CaseFiled;
import org.apache.ibatis.annotations.Param;

public interface CaseFiledRepository {
    void insert(@Param("case") CaseFiled caseFiled,@Param("clientId") int clientId);
}
