package com.solvd.lawoffice.db.dao.jdbc;

import com.solvd.lawoffice.db.binary.Client;
import com.solvd.lawoffice.db.dao.ClientDao;
import com.solvd.lawoffice.db.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDaoImpl implements ClientDao {
    private static final Logger logger = LogManager.getLogger(ClientDaoImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY = "insert into clients values (?,?,?,?)";

    @Override
    public void insert(Client client) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, client.getClientId());
            preparedStatement.setString(2, client.getClientName());
            preparedStatement.setString(3, client.getCountry());
            preparedStatement.setString(4, client.getCity());
            preparedStatement.executeUpdate();
//            preparedStatement.executeQuery();
//            logger.info("Number of rows inserted: " + numberOfRowsCreated);
        } catch (SQLException e) {
            logger.error("incorrect Query");
        } finally {
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException e) {
                    resultset = null;
                }
            }
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
