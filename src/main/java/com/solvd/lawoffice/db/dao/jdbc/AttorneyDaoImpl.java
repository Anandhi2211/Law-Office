package com.solvd.lawoffice.db.dao.jdbc;

import com.solvd.lawoffice.db.binary.Attorney;
import com.solvd.lawoffice.db.dao.AttorneyDao;
import com.solvd.lawoffice.db.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import java.util.ArrayList;
import java.util.Optional;

public class AttorneyDaoImpl implements AttorneyDao {
    private static final Logger logger = LogManager.getLogger(AttorneyDaoImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY = "insert into attorneys values (?,?,?,?,?)";
    static final String FIND_BY_ID_QUERY = "select * from attorneys where attorney_id =";
    static final String UPDATE_CITY_QUERY = "update attorneys set city = ? where attorney_id = ?";
    static final String FIND_ALL_QUERY = "Select * from attorneys";
    static final String FIND_BY_NAME_QUERY = "select * from attorneys where attorney_name =";

    @Override
    public void insert(Attorney attorney, int lawFirmId) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, attorney.getAttorneyId());
            preparedStatement.setString(2, attorney.getAttorneyName());
            preparedStatement.setString(3, attorney.getCountry());
            preparedStatement.setString(4, attorney.getCity());
            preparedStatement.setInt(5, lawFirmId);
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

    @Override
    public Optional<Attorney> findById(int attorney_id) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        Attorney attorney = null;
        try {
            attorney = new Attorney();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(FIND_BY_ID_QUERY + attorney_id);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                attorney = new Attorney();
                attorney.setAttorneyId(resultset.getInt("attorney_id"));
                attorney.setAttorneyName(resultset.getString("attorney_name"));
                attorney.setCountry(resultset.getString("country"));
                attorney.setCity(resultset.getString("city"));
                attorney.setLawFirmId(resultset.getInt("attorney_law_firm_id"));
            }
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
        return Optional.of(attorney);
    }
    @Override
    public void updateCityById(int attorney_id, String city) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(UPDATE_CITY_QUERY);
            preparedStatement.setString(1, city);
            preparedStatement.setInt(2, attorney_id);
            int numberOfRowsCreated = preparedStatement.executeUpdate();
            logger.info("Number of rows Updated: " + numberOfRowsCreated);
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
    public ArrayList<Attorney> findAll() {
        ArrayList<Attorney> attorneyList = new ArrayList<>();
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(FIND_ALL_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            attorneyList = displayTheResults(resultSet);
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
        return attorneyList;
    }
    private ArrayList<Attorney> displayTheResults(ResultSet resultSet) {
        ArrayList<Attorney> attorneyList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Attorney attorney = new Attorney();
                attorney.setAttorneyId(resultSet.getInt("attorney_id"));
                attorney.setAttorneyName(resultSet.getString("attorney_name"));
                attorney.setCountry(resultSet.getString("country"));
                attorney.setCity(resultSet.getString("city"));
                attorney.setLawFirmId(resultSet.getInt("attorney_law_firm_id"));
                attorneyList.add(attorney);
            }
            return attorneyList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Optional<Attorney> findByName(String attorneyName) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        Attorney attorney = null;
        try {
            attorney = new Attorney();
            PreparedStatement preparedStatement = connection
                    .prepareStatement(FIND_BY_NAME_QUERY + attorneyName);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                attorney = new Attorney();
                attorney.setAttorneyId(resultset.getInt("attorney_id"));
                attorney.setAttorneyName(resultset.getString("attorney_name"));
                attorney.setCountry(resultset.getString("country"));
                attorney.setCity(resultset.getString("city"));
                attorney.setLawFirmId(resultset.getInt("attorney_law_firm_id"));
            }
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
        return Optional.of(attorney);
    }
    @Override
    public void deleteById(int attorney_id) {
    }
}