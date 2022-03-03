package com.project;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjectionTest {

    @Test
    void testSqlInjection() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        // misal kita masukan karakter acak di script sql, dan kita salah memasukkan password
        // hasilnya akan tetap bisa login, inilah masalah SQL Injection
        String username = "admin'; #";
        String password = "salah";

        String sql = "SELECT * FROM admin WHERE username = '"+username+"' AND password = '"+password+"'";
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            // success login
            System.out.println("Success login : " + resultSet.getString("username"));
        } else {
            // failed
            System.out.println("Login error");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
