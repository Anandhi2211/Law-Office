package com.solvd.law_office.dao.impl;

import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.dao.AttorneyRepository;
import com.solvd.law_office.dao.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttorneyRepositoryImpl implements AttorneyRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    @Override
    public void create( ){

        Connection connection = CONNECTION_POOL.getConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into bill_details (invoice_no, bill_amount, law_firm_id, client_id) values(582,8500,100,203)");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

}
