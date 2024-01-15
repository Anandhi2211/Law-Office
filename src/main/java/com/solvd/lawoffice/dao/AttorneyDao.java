package com.solvd.lawoffice.dao;

import com.solvd.lawoffice.binary.Attorney;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Optional;

public interface AttorneyDao {
    void insert(@Param("attorney") Attorney attorney, @Param("lawFirmId") int lawFirmId);

    Optional<Attorney> findById(int attorneyId);

    Optional<Attorney> findByName(String attorneyName);

    void deleteById(@Param("attorneyId") int attorney_id);

    void updateCityById(@Param("attorneyId") int attorney_id, @Param("city") String city);

    ArrayList<Attorney> findAll();
}
