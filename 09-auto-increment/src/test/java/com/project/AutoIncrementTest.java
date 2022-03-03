package com.project;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class AutoIncrementTest {

    @Test
    void testAutoIncrement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comments(email, comment) VALUES (?, ?)";

        // saat buat preparedStatement kita beri tahu juga agar mengambil generated keys nya
        // jadi saat kita eksekusi sql nya, maka kita juga akan mendapatkan id nya untuk record data yang kita insert
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, "albert@mail.com");
        preparedStatement.setString(2, "Hello");

        preparedStatement.executeUpdate();

        // kita ambil data id terakhirnya dari ResultSet
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            // data id itu berada pada index 1 di object resultSet
            int id = resultSet.getInt(1);
            System.out.println("Id comment: " + id);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
