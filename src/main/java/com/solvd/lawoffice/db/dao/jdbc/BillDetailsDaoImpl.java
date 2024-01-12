package com.solvd.lawoffice.db.dao.jdbc;

import com.solvd.lawoffice.db.binary.BillDetails;
import com.solvd.lawoffice.db.dao.BillDetailsDao;
import com.solvd.lawoffice.db.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BillDetailsDaoImpl implements BillDetailsDao {
    private static final Logger logger = LogManager.getLogger(BillDetailsDaoImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY ="insert into bill_details values (?,?,?,?)" ;
    @Override
    public void insert(BillDetails billDetails, int clientId) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, billDetails.getInvoiceNumber());
            preparedStatement.setInt(2, billDetails.getBillAmount());
            preparedStatement.setInt(3, billDetails.getLawFirmId());
            preparedStatement.setInt(4, clientId);
            int numberOfRowsCreated = preparedStatement.executeUpdate();
            logger.info("Number of rows inserted: " + numberOfRowsCreated);
            resultset = preparedStatement.executeQuery();
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
