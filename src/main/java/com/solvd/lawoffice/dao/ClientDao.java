package com.solvd.lawoffice.dao;

import com.solvd.lawoffice.binary.Client;
import org.apache.ibatis.annotations.Param;

public interface ClientDao {
    void insert(@Param("client") Client client);
}
