package com.solvd.lawoffice.db.service.jdbc;

import com.solvd.lawoffice.db.binary.BillDetails;
import com.solvd.lawoffice.db.binary.CaseFiled;
import com.solvd.lawoffice.db.binary.Client;
import com.solvd.lawoffice.db.dao.ClientDao;
import com.solvd.lawoffice.db.service.mybatis.ClientMyBatisImpl;
import com.solvd.lawoffice.db.service.BillDetailsService;
import com.solvd.lawoffice.db.service.CaseService;
import com.solvd.lawoffice.db.service.ClientService;

public class ClientJdbcImpl implements ClientService {
    private final CaseService caseService;
    private final BillDetailsService billDetailsService;
    private final ClientDao clientDao;
    public ClientJdbcImpl() {
        this.clientDao = new ClientMyBatisImpl();
        this.caseService = new CaseServiceImpl();
        this.billDetailsService = new BillDetailsServiceImpl();
    }
    @Override
    public Client insert(Client client) {
        this.clientDao.insert(client);
        for(CaseFiled caseFiled : client.getCaseFiledList()){
            this.caseService.insert(caseFiled,client.getClientId());
        }
        for(BillDetails billDetails : client.getBillDetailList()){
            this.billDetailsService.insert(billDetails,client.getClientId());
        }
        return client;
    }
}
