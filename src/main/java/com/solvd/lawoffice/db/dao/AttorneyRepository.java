package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.bin.Attorney;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Optional;

public interface AttorneyRepository {

    void insert(@Param("attorney") Attorney attorney, @Param("lawFirmId") int lawFirmId);
    Optional<Attorney> findById(int attorneyId);
    Optional<Attorney> findByName(String attorneyName);
    void deleteById( int attorney_id);
    void updateCityById(@Param("attorneyId") int attorney_id,@Param("city") String city);
    void addAssociationBar(int attorney_id, int associationBarId);
    ArrayList<Attorney> findAll();
    ArrayList<Attorney> findByCountry(String country);
}
