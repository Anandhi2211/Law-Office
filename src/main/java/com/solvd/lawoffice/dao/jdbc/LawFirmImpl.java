package com.solvd.lawoffice.dao.jdbc;

import com.solvd.lawoffice.binary.LawFirm;
import com.solvd.lawoffice.dao.LawFirmDao;
import com.solvd.lawoffice.util.dbconfig.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LawFirmImpl implements LawFirmDao {
    private static final Logger logger = LogManager.getLogger(LawFirmImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    static final String INSERT_QUERY = "INSERT INTO law_firms VALUES (?,?,?,?,?)";

    @Override
    public void insert(LawFirm lawFirm) {
        Connection connection = CONNECTION_POOL.getConnection();
        ResultSet resultset = null;
        try(PreparedStatement ps = connection
                .prepareStatement(INSERT_QUERY)) {
            ps.setInt(1, lawFirm.getLawFirmId());
            ps.setString(2, lawFirm.getLawFirmName());
            ps.setString(3, lawFirm.getAddress());
            ps.setString(4, lawFirm.getCountry());
            ps.setString(5, lawFirm.getCity());
            int numberOfRecords = ps.executeUpdate();
            resultset = ps.executeQuery();
            logger.info("No of Record inserted: " + numberOfRecords);
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

    public ArrayList<LawFirm> findAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        ArrayList<LawFirm> lawFirmsList = new ArrayList<>();
        ResultSet resultset = null;
        try(PreparedStatement ps = connection
                .prepareStatement("Select * from law_firms")) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                LawFirm lawFirm = new LawFirm();
                lawFirm.setLawFirmId(resultSet.getInt("law_firm_id"));
                lawFirm.setLawFirmName(resultSet.getString("law_firm_name"));
                lawFirm.setAddress(resultSet.getString("address"));
                lawFirm.setCountry(resultSet.getString("country"));
                lawFirm.setCity(resultSet.getString("city"));
                lawFirmsList.add(lawFirm);
            }
            resultset = ps.executeQuery();
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
        return lawFirmsList;
    }
}
