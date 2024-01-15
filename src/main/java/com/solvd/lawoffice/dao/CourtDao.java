package com.solvd.lawoffice.dao;

import com.solvd.lawoffice.binary.Court;
import com.solvd.lawoffice.binary.Judge;
import org.apache.ibatis.annotations.Param;

public interface CourtDao {
    void insert(@Param("court") Court court, @Param("judge") Judge judge);
}
