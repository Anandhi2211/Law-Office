package com.solvd.lawoffice.db.dao.jdbc;

import com.solvd.lawoffice.db.binary.Court;
import com.solvd.lawoffice.db.dao.CourtDao;
import com.solvd.lawoffice.db.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourtDaoImpl implements CourtDao {
    private static final Logger logger = LogManager.getLogger(CourtDaoImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY = "insert into courts values (?,?,?,?)";

    @Override
    public void insert(Court court, int judgeId) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, court.getCourtId());
            preparedStatement.setString(2, court.getCountry());
            preparedStatement.setString(3, court.getCity());
            preparedStatement.setInt(4, judgeId);
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
