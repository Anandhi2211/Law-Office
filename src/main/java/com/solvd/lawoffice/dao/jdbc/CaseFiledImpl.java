package com.solvd.lawoffice.dao.jdbc;

import com.solvd.lawoffice.binary.CaseFiled;
import com.solvd.lawoffice.dao.CaseFiledDao;
import com.solvd.lawoffice.util.dbconfig.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CaseFiledImpl implements CaseFiledDao {
    private static final Logger logger = LogManager.getLogger(CaseFiledImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY = "insert into cases values (?,?,?,?,?,?)";
    @Override
    public void insert(CaseFiled caseFiled, int clientId) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement ps = connection
                .prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, caseFiled.getCaseFiledId());
            ps.setString(2, caseFiled.getCaseDescription());
            ps.setInt(3, clientId);
            ps.setInt(4, caseFiled.getAttorneyId());
            ps.setInt(5, caseFiled.getCaseCategoryId());
            ps.setInt(6, caseFiled.getCourtId());
            int numberOfRowsCreated = ps.executeUpdate();
            logger.info("Number of rows inserted: " + numberOfRowsCreated);
        } catch (SQLException e) {
            logger.error("incorrect Query");
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
