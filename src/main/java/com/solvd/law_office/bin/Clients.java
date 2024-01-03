package com.solvd.law_office.bin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Clients {
    private ArrayList<Client> clients;

    public ArrayList<Client> getClients() {
        if(this.clients == null){
            this.clients = new ArrayList<>();
        }
        return this.clients;
    }

    public void setClients(Client client) {
        this.clients.add(client);
    }

}
