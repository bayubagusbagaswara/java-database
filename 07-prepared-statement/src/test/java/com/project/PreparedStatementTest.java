package com.project;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTest {

    @Test
    void testPrepareStatement() throws SQLException {
        // ambil connection
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        // create preparedStatement using object connection
        // tapi kita harus memasukkan perintah sql nya didalam preparedStatement
        // Ingat jangan memasukkan parameter sql dengan concat string, ada caranya sendiri untuk memasukkan sebuah parameter
        // tapi setiap parameter input user kita ganti dengan tanda tanya ?

        String username = "admin";
        String password = "admin";
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // subtitusi input user kedalam preparedStatement
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        // di method executeQuery kita tidak perlu lagi memasukkan perintah sql
        // karena sudah kita masukkan di prepredStatement
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("Sukses login: " + resultSet.getString("username"));
        } else {
            System.out.println("Gagal login");
        }

        preparedStatement.close();
        connection.close();
    }
}
