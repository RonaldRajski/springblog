package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repo.PostRepository;
import com.codeup.springblog.repo.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.userDao = userDao;
        this.postDao = postDao;
        this.emailService = emailService;
    }

//    List<Post> posts = new ArrayList<>();

    @GetMapping("/posts")
    public String seeAllPosts(Model viewModel){
        List<Post> postsFromdb = postDao.findAll();
        viewModel.addAttribute("posts", postsFromdb);
        // do not use a / to reference a template
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showOnePost(@PathVariable Long id, Model vModel){
        vModel.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String viewPostForm(Model vModel){
        vModel.addAttribute("post",new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    //    public String createToDatabase(@RequestParam("title") String title, @RequestParam("body") String body, Model model) {
    public String createToDatabase(@ModelAttribute Post post, Model model) {
        User author = userDao.getOne(1L);
        post.setAuthor(author);
        postDao.save(post);
        emailService.prepareAndSend(post, "Your post was successfully posted!", "You can view it at http://localhost:8080/posts/" + post.getId());
        model.addAttribute("alert", "<div class=\"alert alert-success\" role=\"alert\">\n" +
                "  The post was added successfully.</div>");
        return "redirect:/posts/" + post.getId();
    }






//    @ResponseBody
//    public String createPost(@ModelAttribute Post postToCreate){
//
//        User userToAdd = userDao.getOne(1L);
//
//        // save the post
//        postDao.save(postToCreate);
//        // set the user
//        postToCreate.setOwner(userToAdd);
//        Post savedPost = postDao.save(postToCreate);
//        EmailService.prepareAndSend(savedPost,"Here is the title", "Here is the body");




//        // set the user
//        postToSave.setOwner(userToAdd);
//
//        // Now lets save our post;
//        postDao.save(postToSave);

//        return "redirect:/posts";
//    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditForm(Model vModel, @PathVariable Long id){
        vModel.addAttribute("post",postDao.getOne(id));
        return "posts/create";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post postToUpdate, @PathVariable Long id){

        User userToAdd = userDao.getOne(2L);

        System.out.println();

        postToUpdate.setId(id);

        // set the user
        postToUpdate.setOwner(userToAdd);

        // Now lets save our post;
        postDao.save(postToUpdate);

        return "redirect:/posts";
    }

}





















