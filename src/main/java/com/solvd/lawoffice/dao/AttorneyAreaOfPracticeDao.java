package com.solvd.lawoffice.dao;

import org.apache.ibatis.annotations.Param;

public interface AttorneyAreaOfPracticeDao {
    void deleteByAreaOfPracticeId(@Param("areaOfPracticeId") int areaOfPracticeId);

    void deleteAttorneyById(@Param("attorneyId") int attorneyId);
}
