package com.solvd.lawoffice.dao.jdbc;

import com.solvd.lawoffice.binary.BillDetails;
import com.solvd.lawoffice.dao.BillDetailsDao;
import com.solvd.lawoffice.util.dbconfig.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillDetailsImpl implements BillDetailsDao {
    private static final Logger logger = LogManager.getLogger(BillDetailsImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY = "insert into bill_details values (?,?,?,?)";

    @Override
    public void insert(BillDetails billDetails, int clientId) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection
                .prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, billDetails.getInvoiceNumber());
            ps.setInt(2, billDetails.getBillAmount());
            ps.setInt(3, billDetails.getLawFirmId());
            ps.setInt(4, clientId);
            int numberOfRowsCreated = ps.executeUpdate();
            logger.info("Number of rows inserted: " + numberOfRowsCreated);
        } catch (SQLException e) {
            logger.error("incorrect Query");
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
