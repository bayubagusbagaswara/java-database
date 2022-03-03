package com.project;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTest {

    @Test
    void testExecuteQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                SELECT * FROM customers
                """;

        // execute query
        ResultSet resultSet = statement.executeQuery(sql);

        // iterasi untuk mendapatkan tiap data dari object result set
        while (resultSet.next()) {

            // ambil data id nya, di record saat ini saya berada, karena tipe data column id kita adalah string, maka gunakan method getString(column)
            String id = resultSet.getString("id");
            // bisa juga menambahkan prefix di depannya untuk nama table nya
            String name = resultSet.getString("customers.name");
            String email = resultSet.getString("email");

            // print data tiap record
            System.out.println(
                    String.join(", ", id, name, email)
            );
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
