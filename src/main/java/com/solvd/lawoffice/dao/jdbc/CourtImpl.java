package com.solvd.lawoffice.dao.jdbc;

import com.solvd.lawoffice.binary.Court;
import com.solvd.lawoffice.dao.CourtDao;
import com.solvd.lawoffice.util.dbconfig.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourtImpl implements CourtDao {
    private static final Logger logger = LogManager.getLogger(CourtImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY = "insert into courts values (?,?,?,?)";

    @Override
    public void insert(Court court, int judgeId) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try(PreparedStatement ps = connection
                .prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, court.getCourtId());
            ps.setString(2, court.getCountry());
            ps.setString(3, court.getCity());
            ps.setInt(4, judgeId);
            int numberOfRowsCreated = ps.executeUpdate();
          resultset = ps.executeQuery();
            logger.info("Number of rows inserted: " + numberOfRowsCreated);
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
