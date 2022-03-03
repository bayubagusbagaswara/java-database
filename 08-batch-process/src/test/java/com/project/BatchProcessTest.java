package com.project;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class BatchProcessTest {

    @Test
    void testStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO comments(email, comment) VALUES ('albert@mail.com', 'Hai')";

        // perulangan untuk 1000 kali melakukan insert data
        // kita tumpuk dulu 1000 data ke batch
        // setelah itu baru eksekusi batch nya
        for (int i = 0; i < 1000; i++) {
            statement.addBatch(sql);
        }

        // kirim statement dalam satu batch
        statement.executeBatch();
        statement.close();
        connection.close();
    }

    @Test
    void testPreparedStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String sql = "INSERT INTO comments(email, comment) VALUES (?, ?)";

        // create preparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < 1000; i++) {
            // disini kita bisa memasukkan nilai parameter ke sql nya
            // tapi kita hapus dulu paremeter di sql sebelumnya, lalu set ulang lagi parameternya
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "albert@mail.com");
            preparedStatement.setString(2, "Hello");
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();

        preparedStatement.close();
        connection.close();
    }
}
