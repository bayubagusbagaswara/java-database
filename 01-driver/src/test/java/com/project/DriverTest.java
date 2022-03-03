package com.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTest {

    @Test
    void testRegister() {

        try {
            // create object Driver mysql
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();

            // register driver to jdbc
            DriverManager.registerDriver(mysqlDriver);

        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }
}
