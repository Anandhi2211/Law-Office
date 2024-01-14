package com.solvd.lawoffice.service.impl;

import com.solvd.lawoffice.binary.BillDetails;
import com.solvd.lawoffice.binary.CaseFiled;
import com.solvd.lawoffice.binary.Client;
import com.solvd.lawoffice.dao.ClientDao;
import com.solvd.lawoffice.service.BillDetailsService;
import com.solvd.lawoffice.service.CaseService;
import com.solvd.lawoffice.service.ClientService;
import com.solvd.lawoffice.util.ConfigUtil;

import java.lang.reflect.InvocationTargetException;

public class ClientServiceImpl implements ClientService {
    private final CaseService caseService;
    private final BillDetailsService billDetailsService;
    private final ClientDao clientDao;
    public ClientServiceImpl() {
        final String path = ConfigUtil.getPathToDaoImplFolder();
        try {
            this.clientDao = (ClientDao) Class.forName(path+"ClientImpl").getConstructor().newInstance();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }        this.caseService = new CaseFiledServiceImpl();
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
