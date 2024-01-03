package com.solvd.law_office.dao;

import com.solvd.law_office.bin.Award;
import org.apache.ibatis.annotations.Param;

public interface LawFirmAwardRepository {
    void insert(@Param("award") Award award, @Param("lawFirmId") int lawFirmId);
}
