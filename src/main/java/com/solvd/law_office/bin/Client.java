package com.solvd.law_office.bin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Client {
    private int clientId;
    private String clientName;
    private String country;
    private String city;
    @JsonProperty("CaseFiled")
    private ArrayList<CaseFiled> caseFiledList;
    @JsonProperty("BillDetails")
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
    @JsonProperty("caseFiledList")
    public ArrayList<CaseFiled> getCaseFiledList() {
        if(this.caseFiledList==null){
            this.caseFiledList = new ArrayList<>();
        }
        return this.caseFiledList;
    }
    @JsonProperty("CaseFiled")
    public void setCaseFiledList(CaseFiled caseFiled) {
        this.caseFiledList.add(caseFiled);
    }
    @JsonProperty("billDetailList")
    public ArrayList<BillDetails> getBillDetailList() {
        if(this.billDetailList == null){
            this.billDetailList = new ArrayList<>();
        }
        return this.billDetailList;
    }
    @JsonProperty("BillDetails")
    public void setBillDetailList(BillDetails billDetail) {
        this.billDetailList.add(billDetail);
    }
}
