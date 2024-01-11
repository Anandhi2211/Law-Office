package com.solvd.law_office.db.dao.jdbc;

import com.solvd.law_office.db.bin.Attorney;
import com.solvd.law_office.db.dao.AttorneyRepository;
import com.solvd.law_office.db.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import java.util.ArrayList;
import java.util.Optional;

public class AttorneyDaoImpl implements AttorneyRepository {
    private static final Logger logger = LogManager.getLogger(AttorneyDaoImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void insert(Attorney attorney, int lawFirmId) {

        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into attorneys values (?,?,?,?,?)");
            preparedStatement.setInt(1, attorney.getAttorneyId());
            preparedStatement.setString(2, attorney.getAttorneyName());
            preparedStatement.setString(3, attorney.getCountry());
            preparedStatement.setString(4, attorney.getCity());
            preparedStatement.setInt(5, lawFirmId);
            int numberOfRowsCreated = preparedStatement.executeUpdate();
            logger.info("Number of rows inserted: " + numberOfRowsCreated);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Attorney> findById(int attorney_id) {

        return null;
    }

    @Override
    public Optional<Attorney> findByName(String attorneyName) {
        return Optional.empty();
    }

    @Override
    public void deleteById(int attorney_id) {

    }

    @Override
    public void updateCityById(int attorney_id, String city) {

    }

    @Override
    public void addAssociationBar(int attorney_id, int associationBarId) {

    }

    @Override
    public ArrayList<Attorney> findAll() {
        ArrayList<Attorney> attorneyList;
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("Select * from attorneys");
            ResultSet resultSet = preparedStatement.executeQuery();
            attorneyList = displayTheResults(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return attorneyList;
    }

    @Override
    public ArrayList<Attorney> findByCountry(String country) {
        return null;
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
}