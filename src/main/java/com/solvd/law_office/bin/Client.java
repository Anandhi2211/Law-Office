package com.solvd.law_office.bin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Client {
    private int clientId;
    private String clientName;
    private String country;
    private String city;
    @JsonDeserialize(as=ArrayList.class,contentAs = CaseFiled.class)
    private ArrayList<CaseFiled> caseFiledList;
    @JsonDeserialize(as=ArrayList.class,contentAs = BillDetails.class)

    private ArrayList<BillDetails> billDetailList;
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
    public ArrayList<CaseFiled> getCaseFiledList() {
        return this.caseFiledList;
    }
    public void setCaseFiledList(CaseFiled caseFiled) {
        this.caseFiledList.add(caseFiled);
    }
    public ArrayList<BillDetails> getBillDetailList() {
        return billDetailList;
    }
    public void setBillDetailList(BillDetails billDetail) {
        this.billDetailList.add(billDetail);
    }
}
