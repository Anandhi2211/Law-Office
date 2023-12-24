package com.solvd.law_office.bin;

import java.util.ArrayList;

public class Attorney    {
    private int attorneyId;
    private String attorneyName;
    private String country;
    private String city;
    public int getLawFirmId() {
        return this.lawFirmId;
    }
    public void setLawFirmId(int lawFirmId) {
        this.lawFirmId = lawFirmId;
    }
    private int lawFirmId;
    public ArrayList<Integer> getClientIdList() {
        return this.clientIdList;
    }
    public void setClientIdList(Integer clientIdList) {
        this.clientIdList.add(clientIdList);
    }
    private ArrayList<Integer> clientIdList;
    public ArrayList<Integer> getAssociationBarIdList() {
        return this.associationBarIdList;
    }
    public void setAssociationBarIdList(int associationBarId) {
        if(this.associationBarIdList==null){
            this.associationBarIdList = new ArrayList<>();
        }
        this.associationBarIdList.add(associationBarId);
    }
    private ArrayList<Integer> associationBarIdList;
    public ArrayList<AssociationBar> getAssociationBarList() {
        return this.associationBarList;
    }
    public void setAssociationBarList(AssociationBar associationBar) {
        if(this.associationBarList == null){
            this.associationBarList = new ArrayList<>();
        }
        this.associationBarList.add(associationBar);
    }
    private ArrayList<AssociationBar> associationBarList;
    public int getAttorneyId() {
        return attorneyId;
    }
    public void setAttorneyId(int attorneyId) {
        this.attorneyId = attorneyId;
    }
    public String getAttorneyName() {
        return this.attorneyName;
    }
    public void setAttorneyName(String attorneyName) {
        this.attorneyName = attorneyName;
    }
    public String getCountry() {
        return this.country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}
