package com.example.board.service;

import com.example.board.dto.Page;
import com.example.board.dto.Post;
import com.example.board.mapper.PostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    @Transactional
    public void registerPost(Post post) {
        postMapper.insertPost(post);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getPostList() {
        return postMapper.selectPostList();
    }

    @Override
    @Transactional
    public Post getPost(Long id) {
        postMapper.increaseViewCount(id);
        return postMapper.selectPostById(id);
    }

    @Override
    @Transactional
    public void modifyPost(Post post) {
        postMapper.updatePost(post);
    }

    @Override
    @Transactional
    public void removePost(Long id) {
        postMapper.deletePost(id);
    }

    @Override
    @Transactional(readOnly = true)
    public int getPostCount() {
        return postMapper.selectPostCount();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getPostList(Page page) {
        page.setTotalCount(postMapper.selectPostCount());
        return postMapper.selectPostListPaging(page);
    }
}
