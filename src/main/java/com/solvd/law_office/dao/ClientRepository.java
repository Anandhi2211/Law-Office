package com.solvd.law_office.dao;

import com.solvd.law_office.bin.CaseFiled;
import com.solvd.law_office.bin.Client;
import org.apache.ibatis.annotations.Param;

public interface ClientRepository {
    void insert(@Param("client") Client client);
}
