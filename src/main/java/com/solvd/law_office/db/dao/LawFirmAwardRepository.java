package com.solvd.law_office.db.dao;

import com.solvd.law_office.db.bin.Award;
import org.apache.ibatis.annotations.Param;

public interface LawFirmAwardRepository {
    void insert(@Param("award") Award award, @Param("lawFirmId") int lawFirmId);
}
