package com.project.repository;

import com.project.ConnectionUtil;
import com.project.entity.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {

    @Override
    public void insert(Comment comment) {

        try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "INSERT INTO comments(email, comment) VALUES(?, ?)";
            try (final PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                // masukkan input parameternya
                preparedStatement.setString(1, comment.getEmail());
                preparedStatement.setString(2, comment.getComment());
                preparedStatement.executeUpdate();
                // dapatkan id nya
                try (final ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        comment.setId(resultSet.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Comment findById(Integer id) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comments WHERE id = ?";
            try(final PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                // ambil data di resultSet
                try(final ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // jika ada datanya, maka kita buat object Comment
                        return new Comment(
                                resultSet.getInt("id"),
                                resultSet.getString("email"),
                                resultSet.getString("comment")
                        );
                    } else {
                        // jika resultSet nya kosong, maka return null
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Comment> findAll() {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comments";
            try(final Statement statement = connection.createStatement()) {
                try(final ResultSet resultSet = statement.executeQuery(sql)) {
                    // create object List untuk menyimpan data yang kita ambil dari resultSet
                    List<Comment> commentList = new ArrayList<>();
                    // ambil data di resultSet
                    while (resultSet.next()) {
                        commentList.add(new Comment(
                                resultSet.getInt("id"),
                                resultSet.getString("email"),
                                resultSet.getString("comment")
                        ));
                    }
                    return commentList;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Comment> findAllByEmail(String email) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM comments WHERE email = ?";
            try(final PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, email);
                // execute sql nya
                try(final ResultSet resultSet = preparedStatement.executeQuery()) {
                    List<Comment> commentList = new ArrayList<>();
                    // ambil data di resultSet
                    while (resultSet.next()) {
                        commentList.add(new Comment(
                                resultSet.getInt("id"),
                                resultSet.getString("email"),
                                resultSet.getString("comment")
                        ));
                    }
                    return commentList;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
