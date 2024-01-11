package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.binary.Client;
import org.apache.ibatis.annotations.Param;

public interface ClientDao {
    void insert(@Param("client") Client client);
}
