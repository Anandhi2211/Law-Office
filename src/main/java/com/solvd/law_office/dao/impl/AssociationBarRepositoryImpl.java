package com.solvd.law_office.dao.impl;

import com.solvd.law_office.ConnectionPool;
import com.solvd.law_office.bin.AssociationBar;
import com.solvd.law_office.dao.AssociationBarRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AssociationBarRepositoryImpl implements AssociationBarRepository {
    private static final Logger logger = LogManager.getLogger(AssociationBarRepositoryImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void insert(AssociationBar associationBar) {

        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into association_bars values (?,?)");
            preparedStatement.setInt(1, associationBar.getAssociationBarId());
            preparedStatement.setString(2, associationBar.getAssociationBarName());
            int numberOfRowsCreated = preparedStatement.executeUpdate();
            logger.info("Number of rows inserted: " + numberOfRowsCreated);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
