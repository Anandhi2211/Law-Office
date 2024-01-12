package com.solvd.lawoffice.db.dao.jdbc;

import com.solvd.lawoffice.db.binary.Judge;
import com.solvd.lawoffice.db.dao.JudgeDao;
import com.solvd.lawoffice.db.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JudgeDaoImpl implements JudgeDao {
    private static final Logger logger = LogManager.getLogger(JudgeDaoImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY = "insert into judges values (?,?)";

    @Override
    public void insert(Judge judge) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, judge.getJudgeId());
            preparedStatement.setString(2, judge.getJudgeName());
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
