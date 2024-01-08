package com.solvd.law_office.bin;

public class BillDetails {
    private int billInvoiceNumber;
    private int billAmount;
    private int lawFirmId;
    private int clientId;
    public int getBillInvoiceNumber() {
        return billInvoiceNumber;
    }
    public void setBillInvoiceNumber(int billInvoiceNumber) {
        this.billInvoiceNumber = billInvoiceNumber;
    }
    public int getBillAmount() {
        return billAmount;
    }
    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }
    public int getLawFirmId() {
        return lawFirmId;
    }
    public void setLawFirmId(int lawFirmId) {
        this.lawFirmId = lawFirmId;
    }
    public int getClientId() {
        return clientId;
    }
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
