package com.solvd.law_office.dao.impl;

import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.dao.AttorneyRepository;
import com.solvd.law_office.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttorneyRepositoryImpl implements AttorneyRepository {
    private static final Logger logger = LogManager.getLogger(AttorneyRepositoryImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    @Override
    public void insert(Attorney attorney, int lawFirmId) {

        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into attorneys values (?,?,?,?,?)");
            preparedStatement.setInt(1,attorney.getAttorney_id());
            preparedStatement.setString(2,attorney.getAttorney_name());
            preparedStatement.setString(3,attorney.getCountry());
            preparedStatement.setString(4,attorney.getCity());
            preparedStatement.setInt(5,lawFirmId);
            int numberOfRowsCreated = preparedStatement.executeUpdate();
            logger.info("Number of rows inserted: "+numberOfRowsCreated);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
