package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.bin.Court;
import org.apache.ibatis.annotations.Param;

public interface CourtRepository {
    void insert(@Param("court") Court court, @Param("judgeId") int judgeId);
}