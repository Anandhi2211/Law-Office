package com.solvd.law_office.dao;

import com.solvd.law_office.bin.Court;
import org.apache.ibatis.annotations.Param;

public interface CourtRepository {
    void insert(@Param("court") Court court, @Param("judgeId") int judgeId);
}
