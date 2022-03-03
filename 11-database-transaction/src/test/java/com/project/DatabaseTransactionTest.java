package com.project;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class DatabaseTransactionTest {

    @Test
    void testCommmit() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        // start transaction, must be false
        connection.setAutoCommit(false);

        String sql = """
                INSERT INTO comments(email, comment)
                VALUES (?, ?)
                """;

        // insert 100 data
        for (int i = 0; i < 100; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "albert@mail.com");
            preparedStatement.setString(2, "Hello");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }

        // finish transaction, must be commit
        connection.commit();
        
        connection.close();
    }

    @Test
    void testRollback() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        // start transaction, must be false
        connection.setAutoCommit(false);

        String sql = """
                INSERT INTO comments(email, comment)
                VALUES (?, ?)
                """;

        // insert 100 data
        for (int i = 0; i < 100; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "albert@mail.com");
            preparedStatement.setString(2, "Hello");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }

        // rollback transaction for not saving data
        connection.rollback();

        connection.close();
    }
}
