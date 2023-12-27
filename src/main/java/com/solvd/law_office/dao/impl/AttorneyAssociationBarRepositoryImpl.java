package com.solvd.law_office.dao.impl;

import com.solvd.law_office.ConnectionPool;
import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.dao.AttorneyAssociationBarRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttorneyAssociationBarRepositoryImpl implements AttorneyAssociationBarRepository {
    private static final Logger logger = LogManager.getLogger(AttorneyAssociationBarRepositoryImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void insert(int associationBar, Attorney attorney) {

        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into attorney_association_bars values (?,?)");
            preparedStatement.setInt(1, attorney.getAttorneyId());
            preparedStatement.setInt(2, associationBar);
            int numberOfRowsCreated = preparedStatement.executeUpdate();
            logger.info("Number of rows inserted: " + numberOfRowsCreated);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(int attorneyId) {

    }
}
