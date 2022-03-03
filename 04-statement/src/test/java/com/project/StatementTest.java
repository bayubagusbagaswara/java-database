package com.project;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {

    @Test
    void testCreateStatement() throws SQLException {

        // ambil object connection from pool data source
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        // create object statement milik object connection
        Statement statement = connection.createStatement();

        // setelah menggunakan statement, juga harus di close
        statement.close();

        connection.close();
    }

    @Test
    void testExecuteUpdate() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        // kita buat perintah sql
        String sql = """
                INSERT INTO customers(id, name, email)
                VALUES ('newton', 'Issac Newton', 'newton@mail.com')
                """;

        // ekseksusi statement dan masukkan perintah sql nya
        // balikan datanya adalah jumlah record/baris yang terupdate
        int update = statement.executeUpdate(sql);
        System.out.println(update);

        statement.close();
        connection.close();
    }

    @Test
    void testExecuteDelete() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        // perintah sql delete
        String sql = """
                DELETE FROM customers;
                """;

        int update = statement.executeUpdate(sql);
        System.out.println(update);

        statement.close();
        connection.close();
    }

    @Test
    void testExecuteQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        // perintah sql SELECT artinya ada data yang akan dikembalikan dari query nya
        String sql = """
                SELECT * FROM customers;
                """;

        // menggunakan executeQuery, balikannya adalah object ResultSet
        // ResultSet yang menampung data hasil query
        ResultSet resultSet = statement.executeQuery(sql);

        // resultSet juga perlu di close
        resultSet.close();

        statement.close();
        connection.close();
    }
}
