package com.solvd.lawoffice.dao.mybatis;

import com.solvd.lawoffice.binary.Client;
import com.solvd.lawoffice.dao.ClientDao;
import com.solvd.lawoffice.util.dbconfig.DaoConfig;
import org.apache.ibatis.session.SqlSession;

public class ClientImpl implements ClientDao {
    @Override
    public void insert(Client client) {

        try(SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            ClientDao clientDao = sqlSession.getMapper(ClientDao.class);
            clientDao.insert(client);
        }
    }
}
