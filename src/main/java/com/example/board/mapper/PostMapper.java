package com.example.board.mapper;

import com.example.board.dto.Page;
import com.example.board.dto.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    int insertPost(Post post);

    List<Post> selectPostList();

    Post selectPostById(Long id);

    int increaseViewCount(Long id);

    int updatePost(Post post);

    int deletePost(Long id);

    int selectPostCount();

    List<Post> selectPostListPaging(Page page);
}
