package com.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {


    @BeforeAll
    static void beforeAll() {
        // sebelum unit test lainnya dijalankan, kita buat dulu object Driver nya
        // lalu registrasi driver
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void testConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/java_database?serverTimezone=Asia/Jakarta";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            // open connection
            System.out.println("Success open connection");

        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testConnectionClose() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/java_database?serverTimezone=Asia/Jakarta";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            // open connection
            System.out.println("Success open connection");

            // close connection
            connection.close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testConnectionAutoCloseable() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/java_database?serverTimezone=Asia/Jakarta";
        String username = "root";
        String password = "root";

        // secara otomatis akan di close koneksinya oleh Java
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {

            System.out.println("Success open connection");

        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }
}
