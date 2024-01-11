package com.solvd.lawoffice.db.dao;

import com.solvd.lawoffice.db.bin.Attorney;
import org.apache.ibatis.annotations.Param;

public interface AttorneyAssociationBarRepository {
    void insert(@Param("associationBarId") int associationBarId, @Param("attorney") Attorney attorney);
    void deleteByAssociationBarId( int associationBarId);
    void addAssociationBarId(@Param("attorneyId") int attorneyId, @Param("associationBarId") int associationBarId);
}
