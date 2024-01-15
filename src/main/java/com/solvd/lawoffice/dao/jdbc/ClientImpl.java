package com.solvd.lawoffice.dao.jdbc;

import com.solvd.lawoffice.binary.Client;
import com.solvd.lawoffice.dao.ClientDao;
import com.solvd.lawoffice.util.dbconfig.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientImpl implements ClientDao {
    private static final Logger logger = LogManager.getLogger(ClientImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY = "insert into clients values (?,?,?,?)";

    @Override
    public void insert(Client client) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try (PreparedStatement ps = connection
                .prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, client.getClientId());
            ps.setString(2, client.getClientName());
            ps.setString(3, client.getCountry());
            ps.setString(4, client.getCity());
            int numberOfRowsCreated = ps.executeUpdate();
//            resultset = ps.executeQuery();
            logger.info("Number of rows inserted: " + numberOfRowsCreated);
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
