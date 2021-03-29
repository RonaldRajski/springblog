package com.codeup.codeup_demo.controllers;

import com.codeup.codeup_demo.models.Post;
import com.codeup.codeup_demo.repo.PostRepository;
import com.codeup.codeup_demo.repo.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class PostController {
    private final PostRepository postDao;
    private Object postsFromdb;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String seeAllAds(Model viewModel) {
        List<Post> adsFromDB = postDao.findAll();
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
    public String createAd(@RequestParam("post_title") String title, @RequestParam("post_body") String body) {

        Post postToSave = new Post(title, body);

        postDao.save(postToSave);


        return "You created a post.";
    }

    @GetMapping("/posts/{id}/update")
    public String updatePostForm(@PathVariable Long id, Model model) {

        Post postFromDb = postDao.getOne(id);

        model.addAttribute("oldPost", postFromDb);

        return "posts/update";
    }

    @PostMapping("/posts/{id}/update")
    @ResponseBody
    public String updateAd(@PathVariable Long id, @RequestParam("post_title") String title, @RequestParam("post_body") String body) {

        Post postToSave = new Post(id, title, body);

        postDao.save(postToSave);
        return "You updated an post.";
    }

    @PostMapping("/ads/{id}/delete")
    @ResponseBody
    public String deletePost(@PathVariable Long id) {
        postDao.deleteById(id);
        return "You deleted an post.";

    }
}












//    @PostMapping("posts/delete")
//    public String deleteIndividualPost(@RequestParam(name = "id") long id, Model model) {
//        postDao.deleteById(id);
//        System.out.println("id = " + id);
//        model.addAttribute("alert", "<div class=\"alert alert-success\" role=\"alert\">\n" +
//                "  The post was successfully deleted. </div>");
//        return "redirect:/posts";
//    }












