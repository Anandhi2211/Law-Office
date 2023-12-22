package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.CaseFiled;
import com.solvd.law_office.dao.ClientRepository;
import com.solvd.law_office.dao.impl.ClientRepositoryImpl;
import com.solvd.law_office.service.ClientService;

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    public ClientServiceImpl() {
        clientRepository = new ClientRepositoryImpl();
    }
    @Override
    public void insert(CaseFiled caseFiled, int lawFirmId) {
    }
}
