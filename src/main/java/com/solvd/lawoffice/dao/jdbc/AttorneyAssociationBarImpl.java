package com.solvd.lawoffice.dao.jdbc;

import com.solvd.lawoffice.dao.AttorneyAssociationBarDao;
import com.solvd.lawoffice.util.dbconfig.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttorneyAssociationBarImpl implements AttorneyAssociationBarDao {
    private static final Logger logger = LogManager.getLogger(AttorneyAssociationBarImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY = "insert into attorney_association_bars values (?,?)";
    static final String DELETE_BY_ASSOCIATION_BAR_ID_QUERY = "delete from attorney_association_bars where association_bar_id=";

    @Override
    public void insert(int associationBar, int attorneyId) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try(PreparedStatement ps = connection
                .prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, attorneyId);
            ps.setInt(2, associationBar);
            int numberOfRowsCreated = ps.executeUpdate();
            logger.info("Number of rows inserted: " + numberOfRowsCreated);
            resultset = ps.executeQuery();
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

    @Override
    public void deleteByAssociationBarId(int associationBarId) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try(PreparedStatement ps = connection
                .prepareStatement(DELETE_BY_ASSOCIATION_BAR_ID_QUERY + associationBarId)) {
            int numberOfRowsCreated = ps.executeUpdate();
            logger.info("Number of rows affected: " + numberOfRowsCreated);
            resultset = ps.executeQuery();
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
