package com.solvd.lawoffice.db.dao.jdbc;

import com.solvd.lawoffice.db.binary.LawFirm;
import com.solvd.lawoffice.db.dao.LawFirmDao;
import com.solvd.lawoffice.db.util.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LawFirmDaoImpl implements LawFirmDao {
    private static final Logger logger = LogManager.getLogger(LawFirmDaoImpl.class);
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
            throw new RuntimeException(e);
        }
        finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
    public ArrayList<LawFirm> findAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        ArrayList<LawFirm> lawFirmsList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("Select * from law_firms");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LawFirm lawFirm = new LawFirm();
                lawFirm.setLawFirmId(resultSet.getInt("law_firm_id"));
                lawFirm.setLawFirmName(resultSet.getString("law_firm_name"));
                lawFirm.setAddress(resultSet.getString("address"));
                lawFirm.setCountry(resultSet.getString("country"));
                lawFirm.setCity(resultSet.getString("city"));
                lawFirmsList.add(lawFirm);
            }
//            lawFirmsList = displayTheResults(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return lawFirmsList;
    }
    private ArrayList<LawFirm> displayTheResults(ResultSet resultSet) {
        ArrayList<LawFirm> lawFirmList = new ArrayList<>();
        try {
            while (resultSet.next()) {
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
