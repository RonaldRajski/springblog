package com.codeup.codeup_demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {



    @GetMapping("/posts")
    @ResponseBody
    public String seeAllPosts(){
        return "All posts will display here";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String showOnePost(@PathVariable int id){
        return "You will see a post with an id of: " +id+ ".";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewPostForm(){
        return "You would come here to create a post.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "You will submit your post here.";
    }




    }



