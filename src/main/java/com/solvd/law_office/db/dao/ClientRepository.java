package com.solvd.law_office.db.dao;

import com.solvd.law_office.db.bin.Client;
import org.apache.ibatis.annotations.Param;

public interface ClientRepository {
    void insert(@Param("client") Client client);
}
