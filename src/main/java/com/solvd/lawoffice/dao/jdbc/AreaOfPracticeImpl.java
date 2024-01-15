package com.solvd.lawoffice.dao.jdbc;

import com.solvd.lawoffice.binary.AreaOfPractice;
import com.solvd.lawoffice.dao.AreaOfPracticeDao;
import com.solvd.lawoffice.util.dbconfig.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AreaOfPracticeImpl implements AreaOfPracticeDao {
    private static final Logger logger = LogManager.getLogger(AssociationBarImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY = "insert into area_of_practices values (?,?)";
    static final String DELETE_QUERY = "delete from area_of_practices where area_of_practice_id = ?";

    @Override
    public void insert(AreaOfPractice areaOfPractice) {

        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection
                .prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, areaOfPractice.getAreaOfPracticeId());
            ps.setString(2, areaOfPractice.getAreaOfPracticeName());
            int numberOfRowsCreated = ps.executeUpdate();
            logger.info("Number of rows inserted: " + numberOfRowsCreated);
        } catch (SQLException e) {
            logger.error("incorrect Query");
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByAreaOfPracticeId(int areaOfPracticeId) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection
                .prepareStatement(DELETE_QUERY )) {
            ps.setInt(1,areaOfPracticeId);
            int numberOfRowsCreated = ps.executeUpdate();
            logger.info("Number of rows Deleted: " + numberOfRowsCreated);
        } catch (SQLException e) {
            logger.error("Incorrect Query");
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
