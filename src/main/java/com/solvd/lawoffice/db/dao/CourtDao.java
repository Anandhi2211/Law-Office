package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.binary.Court;
import org.apache.ibatis.annotations.Param;

public interface CourtDao {
    void insert(@Param("court") Court court, @Param("judgeId") int judgeId);
}
