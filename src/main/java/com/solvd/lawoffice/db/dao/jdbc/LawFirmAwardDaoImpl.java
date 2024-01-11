package com.solvd.lawoffice.db.dao.jdbc;

import com.solvd.lawoffice.db.bin.Award;
import com.solvd.lawoffice.db.dao.LawFirmAwardRepository;
import com.solvd.lawoffice.db.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LawFirmAwardDaoImpl implements LawFirmAwardRepository {
    private static final Logger logger = LogManager.getLogger(LawFirmAwardDaoImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void insert(Award award, int lawFirmId) {

        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into law_firm_has_awards values (?,?)");
            preparedStatement.setInt(1, lawFirmId);
            preparedStatement.setInt(2, award.getAwardId());
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
