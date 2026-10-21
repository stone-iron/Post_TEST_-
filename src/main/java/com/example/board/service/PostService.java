package com.example.board.service;

import com.example.board.dto.Page;
import com.example.board.dto.Post;

import java.util.List;

public interface PostService {

    void registerPost(Post post);

    List<Post> getPostList();

    Post getPost(Long id);

    void modifyPost(Post post);

    void removePost(Long id);

    int getPostCount();

    List<Post> getPostList(Page page);
}
