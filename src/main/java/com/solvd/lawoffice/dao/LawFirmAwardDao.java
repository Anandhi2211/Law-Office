package com.solvd.lawoffice.dao;

import com.solvd.lawoffice.binary.Award;
import org.apache.ibatis.annotations.Param;

public interface LawFirmAwardDao {
    void insert(@Param("award") Award award, @Param("lawFirmId") int lawFirmId);
}
