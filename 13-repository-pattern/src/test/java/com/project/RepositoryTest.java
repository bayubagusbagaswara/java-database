package com.project;

import com.project.entity.Comment;
import com.project.repository.CommentRepository;
import com.project.repository.CommentRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RepositoryTest {

    // kita ingin test repository
    // ini interface CommentRepository
    private CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        // ini create object CommentRepositoryImpl
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void testInsert() {
        Comment comment = new Comment("albert@mail.com", "Hai");
        commentRepository.insert(comment);

        // pastikan jika sukses insert, maka kita dapat data id nya
        Assertions.assertNotNull(comment.getId());
        System.out.println(comment.getId());
    }

    @Test
    void testFindById() {
        Comment comment = commentRepository.findById(3002);
        Assertions.assertNotNull(comment);
        System.out.println(comment.getId());
        System.out.println(comment.getEmail());
        System.out.println(comment.getComment());
        
        Comment notFound = commentRepository.findById(10000000);
        Assertions.assertNull(notFound);
    }

    @Test
    void testFindAll() {
        List<Comment> commentList = commentRepository.findAll();
        System.out.println(commentList.size());
    }

    @Test
    void testFindByEmail() {
        List<Comment> commentList = commentRepository.findAllByEmail("albert@mail.com");
        System.out.println(commentList.size());
    }
}
