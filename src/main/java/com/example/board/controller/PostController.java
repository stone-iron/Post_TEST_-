package com.example.board.controller;

import com.example.board.dto.Page;
import com.example.board.dto.Post;
import com.example.board.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/list")
    public String list(@RequestParam(value = "page", defaultValue = "1") int pageNo, Model model) {
        Page page = new Page(pageNo, 10);
        List<Post> posts = postService.getPostList(page);
        model.addAttribute("posts", posts);
        model.addAttribute("page", page);
        return "Post/list";
    }

    @GetMapping("/insert")
    public String insertForm() {
        return "Post/insert";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute Post post) {
        postService.registerPost(post);
        return "redirect:/Post/list";
    }

    @GetMapping("/read/{id}")
    public String read(@PathVariable("id") Long id, Model model) {
        Post post = postService.getPost(id);
        if (post == null) {
            return "redirect:/Post/list";
        }
        model.addAttribute("post", post);
        return "Post/read";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        Post post = postService.getPost(id);
        if (post == null) {
            return "redirect:/Post/list";
        }
        model.addAttribute("post", post);
        return "Post/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Post post) {
        postService.modifyPost(post);
        return "redirect:/Post/read/" + post.getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        postService.removePost(id);
        return "redirect:/Post/list";
    }
}
