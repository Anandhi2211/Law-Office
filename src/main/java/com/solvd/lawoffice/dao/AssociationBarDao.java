package com.solvd.lawoffice.dao;

import com.solvd.lawoffice.binary.AssociationBar;
import org.apache.ibatis.annotations.Param;

public interface AssociationBarDao {
    void insert(@Param("associationBar") AssociationBar associationBar);

    void deleteByAssociationBarId(@Param("associationBarId") int associationBarId);
}
