package com.solvd.law_office.service.impl;

import com.solvd.law_office.bin.BillDetails;
import com.solvd.law_office.bin.CaseFiled;
import com.solvd.law_office.bin.Client;
import com.solvd.law_office.dao.ClientRepository;
import com.solvd.law_office.dao.impl.ClientRepositoryMyBatisImpl;
import com.solvd.law_office.service.BillDetailsService;
import com.solvd.law_office.service.CaseService;
import com.solvd.law_office.service.ClientService;

public class ClientServiceImpl implements ClientService {
    private final CaseService caseService;
    private final BillDetailsService billDetailsService;
    private final ClientRepository clientRepository;
    public ClientServiceImpl() {
        this.clientRepository = new ClientRepositoryMyBatisImpl();
        this.caseService = new CaseServiceImpl();
        this.billDetailsService = new BillDetailsServiceImpl();
    }
    @Override
    public Client insert(Client client) {
        this.clientRepository.insert(client);
        for(CaseFiled caseFiled : client.getCaseFiledList()){
            this.caseService.insert(caseFiled,client.getClientId());
        }
        for(BillDetails billDetails : client.getBillDetailList()){
            this.billDetailsService.insert(billDetails,client.getClientId());
        }
        return client;
    }
}
