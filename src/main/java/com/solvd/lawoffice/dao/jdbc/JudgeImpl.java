package com.solvd.lawoffice.dao.jdbc;

import com.solvd.lawoffice.binary.Judge;
import com.solvd.lawoffice.dao.JudgeDao;
import com.solvd.lawoffice.util.dbconfig.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JudgeImpl implements JudgeDao {
    private static final Logger logger = LogManager.getLogger(JudgeImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY = "insert into judges values (?,?)";

    @Override
    public void insert(Judge judge) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try (PreparedStatement ps = connection
                .prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, judge.getJudgeId());
            ps.setString(2, judge.getJudgeName());
            int numberOfRowsCreated = ps.executeUpdate();
            logger.info("Number of rows inserted: " + numberOfRowsCreated);
//            resultset = ps.executeQuery();
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
