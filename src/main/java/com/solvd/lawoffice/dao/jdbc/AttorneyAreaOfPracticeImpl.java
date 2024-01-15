package com.solvd.lawoffice.dao.jdbc;

import com.solvd.lawoffice.dao.AttorneyAreaOfPracticeDao;
import com.solvd.lawoffice.util.dbconfig.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttorneyAreaOfPracticeImpl implements AttorneyAreaOfPracticeDao {
    private static final Logger logger = LogManager.getLogger(AttorneyAreaOfPracticeImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String DELETE_BY_AREA_OF_PRACTICE = "delete from attorney_area_of_practices where area_of_practice_id = ?";
    static final String DELETE_BY_ATTORNEY_BY_ID = "delete from attorney_area_of_practices where attorney_id = ? ";

    @Override
    public void deleteByAreaOfPracticeId(int areaOfPracticeId) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection
                .prepareStatement(DELETE_BY_AREA_OF_PRACTICE)) {
            ps.setInt(1, areaOfPracticeId);
            int numberOfRowsCreated = ps.executeUpdate();
            logger.info("Number of rows Deleted: " + numberOfRowsCreated);
        } catch (SQLException e) {
            logger.error("incorrect Query");
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void deleteAttorneyById(int attorneyId) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection
                .prepareStatement(DELETE_BY_ATTORNEY_BY_ID)) {
            ps.setInt(1, attorneyId);
            int numberOfRowsCreated = ps.executeUpdate();
            logger.info("Number of rows Deleted: " + numberOfRowsCreated);
        } catch (SQLException e) {
            logger.error("incorrect Query");
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
