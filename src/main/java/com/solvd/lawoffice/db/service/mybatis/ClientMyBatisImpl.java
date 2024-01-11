package com.solvd.lawoffice.db.service.mybatis;

import com.solvd.lawoffice.db.bin.Client;
import com.solvd.lawoffice.db.dao.ClientDao;
import com.solvd.lawoffice.db.util.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class ClientMyBatisImpl implements ClientDao {
    @Override
    public void insert(Client client) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            ClientDao clientDao = sqlSession.getMapper(ClientDao.class);
            clientDao.insert(client);
        }
    }
}
