package com.solvd.law_office.bin;

import java.util.ArrayList;

public class Attorney    {
    private int attorneyId;
    private String attorneyName;
    private String country;
    private String city;
    private int lawFirmId;
    private ArrayList<Client> clientList;
    public void setAssociationBarIdList( Integer associationBarId) {
        if(this.associationBarIdList==null){
            this.associationBarIdList = new ArrayList<>();
        }
        this.associationBarIdList.add(associationBarId);    }
    private ArrayList<Integer> associationBarIdList;
    public int getLawFirmId() {
        return this.lawFirmId;
    }
    public void setLawFirmId(int lawFirmId) {
        this.lawFirmId = lawFirmId;
    }
    public ArrayList<Client> getClientIdList() {
        return this.clientList;
    }
    public void setClientIdList(Client client) {
        this.clientList.add(client);
    }
    public ArrayList<Integer> getAssociationBarIdList() {
        return this.associationBarIdList;
    }
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
