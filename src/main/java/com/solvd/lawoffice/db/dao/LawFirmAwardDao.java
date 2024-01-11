package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.bin.Award;
import org.apache.ibatis.annotations.Param;

public interface LawFirmAwardDao {
    void insert(@Param("award") Award award, @Param("lawFirmId") int lawFirmId);
}
