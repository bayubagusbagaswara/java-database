package com.project;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionUtil {

    private static HikariDataSource dataSource;

    static {
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

        dataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getDataSource() {
        return dataSource;
    }

}
