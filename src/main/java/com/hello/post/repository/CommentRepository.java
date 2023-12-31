package com.hello.post.repository;

import com.hello.post.entity.Comment;
import com.hello.post.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
