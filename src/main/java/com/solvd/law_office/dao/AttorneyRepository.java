package com.solvd.law_office.dao;

import com.solvd.law_office.bin.Attorney;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Optional;

public interface AttorneyRepository {

    void insert(@Param("attorney") Attorney attorney, @Param("lawFirmId") int lawFirmId);
    Optional<Attorney> findById(@Param("attorney") int attorneyId);
    Optional<Attorney> findByName(@Param("attorney") String attorneyName);
    void deleteById( int attorney_id);
    void updateCityById( @Param("attorneyId") int attorney_id,@Param("city") String city);
    void addAssociationBar(int attorney_id, int associationBarId);
    ArrayList<Attorney> findAll();
}
