package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.bin.Client;
import org.apache.ibatis.annotations.Param;

public interface ClientRepository {
    void insert(@Param("client") Client client);
}