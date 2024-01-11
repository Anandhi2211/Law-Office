package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.bin.Client;
import com.solvd.lawoffice.db.dao.ClientRepository;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class ClientMyBatisImpl implements ClientRepository {
    @Override
    public void insert(Client client) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            ClientRepository clientRepository = sqlSession.getMapper(ClientRepository.class);
            clientRepository.insert(client);
        }
    }
}
