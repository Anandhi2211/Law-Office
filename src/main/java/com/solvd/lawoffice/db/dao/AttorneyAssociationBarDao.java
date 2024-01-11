package com.solvd.lawoffice.db.dao;

import org.apache.ibatis.annotations.Param;

public interface AttorneyAssociationBarDao {
    void insert(@Param("associationBarId") int associationBarId, @Param("attorneyId") int attorneyId);
    void deleteByAssociationBarId( int associationBarId);
    void addAssociationBarId(@Param("attorneyId") int attorneyId, @Param("associationBarId") int associationBarId);
}
