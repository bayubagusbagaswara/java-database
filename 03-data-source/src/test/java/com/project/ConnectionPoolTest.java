package com.project;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {

    @Test
    void testHikariCP() {

        // create configuration HikariConfig
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/java_database?serverTimezone=Asia/Jakarta");
        config.setUsername("root");
        config.setPassword("root");

        config.setMaximumPoolSize(10); // object connection yang bisa dibuat tidak lebih dari 10
        config.setMinimumIdle(5); // connection yang siaga atau siap dipakai
        config.setIdleTimeout(60_000); // waktu connection jika sudah tidak digunakan lagi
        config.setMaxLifetime(10 * 60_000); // waktu untuk maksimal koneksinya, jika lebih waktunya akan dibuatkan connection baru

        try {
            // data source adalah implementasi dari connection pooling
            HikariDataSource dataSource = new HikariDataSource(config);

            // create connection atau ambil connection dari pool nya
            Connection connection = dataSource.getConnection();
            System.out.println("Sukses mengambil koneksi");

            connection.close();
            System.out.println("Sukses mengembalikan koneksi");

            dataSource.close();
            System.out.println("Sukses menutup pool");

        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testUtil() {
        try {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            System.out.println("Sukses mengambil koneksi");

            connection.close();
            System.out.println("Sukses mengembalikan koneksi");

            ConnectionUtil.getDataSource().close();
            System.out.println("Sukses menutup pool");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
