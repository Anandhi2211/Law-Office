package com.solvd.lawoffice.dao;

import org.apache.ibatis.annotations.Param;

public interface AttorneyAssociationBarDao {
    void insert(@Param("associationBarId") int associationBarId, @Param("attorneyId") int attorneyId);

    void deleteByAssociationBarId(int associationBarId);

    void deleteAttorneyById(int attorneyId);
}
