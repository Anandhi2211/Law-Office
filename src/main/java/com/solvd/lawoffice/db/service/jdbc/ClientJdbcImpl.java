package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.bin.BillDetails;
import com.solvd.lawoffice.db.bin.CaseFiled;
import com.solvd.lawoffice.db.bin.Client;
import com.solvd.lawoffice.db.dao.ClientRepository;
import com.solvd.lawoffice.db.service.mybatis.ClientMyBatisImpl;
import com.solvd.lawoffice.db.service.BillDetailsService;
import com.solvd.lawoffice.db.service.CaseService;
import com.solvd.lawoffice.db.service.ClientService;

public class ClientJdbcImpl implements ClientService {
    private final CaseService caseService;
    private final BillDetailsService billDetailsService;
    private final ClientRepository clientRepository;
    public ClientJdbcImpl() {
        this.clientRepository = new ClientMyBatisImpl();
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
