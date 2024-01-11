package com.solvd.law_office.db.dao;

import com.solvd.law_office.db.bin.Court;
import org.apache.ibatis.annotations.Param;

public interface CourtRepository {
    void insert(@Param("court") Court court, @Param("judgeId") int judgeId);
}
