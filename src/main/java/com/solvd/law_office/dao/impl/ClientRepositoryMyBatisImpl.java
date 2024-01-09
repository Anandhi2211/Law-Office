package com.solvd.law_office.dao.impl;

import com.solvd.law_office.bin.CaseFiled;
import com.solvd.law_office.bin.Client;
import com.solvd.law_office.dao.ClientRepository;
import com.solvd.law_office.dao.CourtRepository;
import com.solvd.law_office.dao.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class ClientRepositoryMyBatisImpl implements ClientRepository {
    @Override
    public void insert(Client client) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            ClientRepository clientRepository = sqlSession.getMapper(ClientRepository.class);
            clientRepository.insert(client);
        }
    }
}
