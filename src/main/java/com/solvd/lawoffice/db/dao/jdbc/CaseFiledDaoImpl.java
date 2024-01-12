package com.solvd.lawoffice.db.dao.jdbc;

import com.solvd.lawoffice.db.binary.CaseFiled;
import com.solvd.lawoffice.db.dao.CaseFiledDao;
import com.solvd.lawoffice.db.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CaseFiledDaoImpl implements CaseFiledDao {
    private static final Logger logger = LogManager.getLogger(CaseFiledDaoImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY = "insert into cases values (?,?,?,?,?,?)";
    @Override
    public void insert(CaseFiled caseFiled, int clientId) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, caseFiled.getCaseFiledId());
            preparedStatement.setString(2, caseFiled.getCaseDescription());
            preparedStatement.setInt(3, clientId);
            preparedStatement.setInt(4, caseFiled.getAttorneyId());
            preparedStatement.setInt(5, caseFiled.getCaseCategoryId());
            preparedStatement.setInt(6, caseFiled.getCourtId());
            preparedStatement.executeUpdate();
//            preparedStatement.executeQuery();
//            logger.info("Number of rows inserted: " + numberOfRowsCreated);
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
