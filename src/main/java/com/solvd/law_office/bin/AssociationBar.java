package com.solvd.law_office.bin;

import java.util.ArrayList;

public class AssociationBar {
    private int associationBarId;
    private String associationBarName;

    public ArrayList<Attorney> getAttorneyList() {
        return attorneyList;
    }

    public void setAttorneyList(ArrayList<Attorney> attorneyList) {
        this.attorneyList = attorneyList;
    }

    private ArrayList<Attorney> attorneyList;

    public int getAssociationBarId() {
        return associationBarId;
    }

    public void setAssociationBarId(int associationBarId) {
        this.associationBarId = associationBarId;
    }

    public String getAssociationBarName() {
        return associationBarName;
    }

    public void setAssociationBarName(String associationBarName) {
        this.associationBarName = associationBarName;
    }
}
