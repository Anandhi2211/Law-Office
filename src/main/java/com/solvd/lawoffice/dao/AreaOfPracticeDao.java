package com.solvd.lawoffice.dao;


import com.solvd.lawoffice.binary.AreaOfPractice;
import org.apache.ibatis.annotations.Param;

public interface AreaOfPracticeDao {
    void insert(@Param("areaOfPractice") AreaOfPractice areaOfPractice);

    void deleteByAreaOfPracticeId(@Param("areaOfPracticeId") int areaOfPracticeId);
}
