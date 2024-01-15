package com.solvd.lawoffice.dao.jdbc;

import com.solvd.lawoffice.binary.Award;
import com.solvd.lawoffice.dao.LawFirmAwardDao;
import com.solvd.lawoffice.util.dbconfig.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LawFirmAwardImpl implements LawFirmAwardDao {
    private static final Logger logger = LogManager.getLogger(LawFirmAwardImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY = "insert into law_firm_has_awards values (?,?)";

    @Override
    public void insert(Award award, int lawFirmId) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection
                .prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, lawFirmId);
            ps.setInt(2, award.getAwardId());
            int numberOfRowsCreated = ps.executeUpdate();
            logger.info("Number of rows inserted: " + numberOfRowsCreated);
        } catch (SQLException e) {
            logger.error("incorrect Query");
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
