package com.solvd.law_office.dao.impl;

import com.solvd.law_office.bin.LawFirm;
import com.solvd.law_office.ConnectionPool;
import com.solvd.law_office.dao.LawFirmRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LawFirmRepositoryImpl implements LawFirmRepository {
    private static final Logger logger = LogManager.getLogger(LawFirmRepositoryImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void insert(LawFirm lawFirm) {
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO law_firms VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, lawFirm.getLawFirmId());
            preparedStatement.setString(2, lawFirm.getLawFirmName());
            preparedStatement.setString(3, lawFirm.getAddress());
            preparedStatement.setString(4, lawFirm.getCountry());
            preparedStatement.setString(5, lawFirm.getCity());
            int numberOfRecords = preparedStatement.executeUpdate();
            logger.info("No of Record inserted: " + numberOfRecords);
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    public ArrayList<LawFirm> findAll() {
        ArrayList<LawFirm> lawFirmsList;
        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("Select * from law_firms");
            ResultSet resultSet = preparedStatement.executeQuery();
            lawFirmsList = displayTheResults(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lawFirmsList;
    }

    private ArrayList<LawFirm> displayTheResults(ResultSet resultSet) {

        ArrayList<LawFirm> lawFirmList = new ArrayList<>();

        try {
            if (resultSet.next()) {
                LawFirm lawFirm = new LawFirm();
                lawFirm.setLawFirmId(resultSet.getInt("law_firm_id"));
                lawFirm.setLawFirmName(resultSet.getString("law_firm_name"));
                lawFirm.setAddress(resultSet.getString("address"));
                lawFirm.setCountry(resultSet.getString("country"));
                lawFirm.setCity(resultSet.getString("city"));
                lawFirmList.add(lawFirm);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lawFirmList;
    }
}
