package com.project;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class MetadataTest {

    @Test
    void testDataMetadata() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        // dapatkan DatabaseMetaData
        DatabaseMetaData databaseMetaData = connection.getMetaData();

        String databaseProductName = databaseMetaData.getDatabaseProductName();
        String databaseProductVersion = databaseMetaData.getDatabaseProductVersion();

        ResultSet resultSet = databaseMetaData.getTables("java_database", null, null, null);

        while (resultSet.next()) {
            String tableName = resultSet.getString("TABLE_NAME");
            System.out.println("Table: " + tableName);
        }

        System.out.println(databaseProductName);
        System.out.println(databaseProductVersion);

        connection.close();
    }

    @Test
    void testParameterMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String sql = "INSERT INTO comments(email, comment) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // mendapatkan parameter metadata
        ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();

        // jumlah parameter
        System.out.println(parameterMetaData.getParameterCount());
        // type parameter, tapi MySQL belum support
        // System.out.println(parameterMetaData.getParameterTypeName(1));

        preparedStatement.close();
        connection.close();
    }

    @Test
    void testResultSetMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");
        
        // mendapatkan detail resultSet
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        
        // jumlah kolom resultSet
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            System.out.println("Name: " + resultSetMetaData.getColumnName(i));
            System.out.println("Type: " + resultSetMetaData.getColumnType(i));
            System.out.println("Type Name: " + resultSetMetaData.getColumnTypeName(i));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
