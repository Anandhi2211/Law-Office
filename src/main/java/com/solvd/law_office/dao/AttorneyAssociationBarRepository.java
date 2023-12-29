package com.solvd.law_office.dao;

import com.solvd.law_office.bin.AssociationBar;
import com.solvd.law_office.bin.Attorney;
import org.apache.ibatis.annotations.Param;

public interface AttorneyAssociationBarRepository {
    void insert(@Param("associationBarId") int associationBarId, @Param("attorney") Attorney attorney);
    void deleteById( int attorneyId);
}
