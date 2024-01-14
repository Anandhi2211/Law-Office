package com.solvd.lawoffice.dao.jdbc;

import com.solvd.lawoffice.binary.Attorney;
import com.solvd.lawoffice.dao.AttorneyDao;
import com.solvd.lawoffice.util.dbconfig.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import java.util.ArrayList;
import java.util.Optional;

public class AttorneyImpl implements AttorneyDao {
    private static final Logger logger = LogManager.getLogger(AttorneyImpl.class);
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
        try (PreparedStatement ps = connection
                .prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, attorney.getAttorneyId());
            ps.setString(2, attorney.getAttorneyName());
            ps.setString(3, attorney.getCountry());
            ps.setString(4, attorney.getCity());
            ps.setInt(5, lawFirmId);
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

    @Override
    public Optional<Attorney> findById(int attorney_id) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        Attorney attorney = null;
        try(PreparedStatement ps = connection
                .prepareStatement(FIND_BY_ID_QUERY + attorney_id)) {
            attorney = new Attorney();
            resultset = ps.executeQuery();
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
        try(PreparedStatement ps = connection
                .prepareStatement(UPDATE_CITY_QUERY)) {
            ps.setString(1, city);
            ps.setInt(2, attorney_id);
            int numberOfRowsCreated = ps.executeUpdate();
            resultset = ps.executeQuery();
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
        try(PreparedStatement ps = connection
                .prepareStatement(FIND_ALL_QUERY)) {
            ps.executeQuery();
            resultset = ps.executeQuery();
            attorneyList = displayTheResults(resultset);
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
        try(PreparedStatement preparedStatement = connection
                .prepareStatement(FIND_BY_NAME_QUERY + attorneyName)) {
            attorney = new Attorney();
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