package com.solvd.law_office.bin;

import java.util.ArrayList;

public class Client {
    private int clientId;
    private String clientName;
    private String country;
    private String city;
    private ArrayList<Integer> caseFiledIdList;
    public int getClientId() {
        return this.clientId;
    }
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public String getClientName() {
        return this.clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
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
    public ArrayList<Integer> getCaseFiledIdList() {
        return this.caseFiledIdList;
    }
    public void setCaseFiledIdList(Integer caseFiledId) {
        this.caseFiledIdList.add(caseFiledId);
    }
}
