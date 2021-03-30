package com.codeup.codeup_demo.controllers;

import com.codeup.codeup_demo.models.Post;
import com.codeup.codeup_demo.models.User;
import com.codeup.codeup_demo.repo.PostRepository;
import com.codeup.codeup_demo.repo.PostRepository;
import com.codeup.codeup_demo.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String seeAllPosts(Model viewModel) {
        List<Post> postsFromdb = postDao.findAll();
        viewModel.addAttribute("posts", postsFromdb);
        // do not use a / to reference a template
        return "posts/index";
    }


    @GetMapping("posts/{id}")
    public String showOneAd(@PathVariable Long id, Model vModel) {
        vModel.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewPostForm(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(@RequestParam String post_title,@RequestParam(name = "post_body") String body){
        Post postToSave = new Post();
        User userToAdd = userDao.getOne(2L);

        // Setting the title here
        postToSave.setTitle(post_title);

        // setting the body here
        postToSave.setBody(body);

        // set the user
        postToSave.setOwner(userToAdd);

        // Now lets save our post;
        postDao.save(postToSave);

        return "You created a post!";
    }


    @GetMapping("/posts/{id}/update")
    public String updatePostForm(@PathVariable Long id, Model model) {

        Post postFromdb = postDao.getOne(id);

        model.addAttribute("oldPost", postFromdb);

        return "posts/update";
    }

//    @PostMapping("/posts/{id}/update")
//    @ResponseBody
//    public String updateAd(@PathVariable Long id, @RequestParam("post_title") String title, @RequestParam("post_body") String body) {
//
//        Post postToSave = new Post(id, title, body);
//
//        postDao.save(postToSave);
//        return "You updated an post.";
//    }

    @PostMapping("/posts/{id}/delete")
    @ResponseBody
    public String deletePost(@PathVariable Long id) {
        postDao.deleteById(id);
        return "You deleted an post.";

    }


    @PostMapping("posts/delete")
    public String deleteIndividualPost(@RequestParam(name = "id") long id, Model model) {
        postDao.deleteById(id);
        System.out.println("id = " + id);
        model.addAttribute("alert", "<div class=\"alert alert-success\" role=\"alert\">\n" +
                "  The post was successfully deleted. </div>");
        return "redirect:/posts";
    }
}












