package com.ubit.hibernate.controller;

import com.ubit.hibernate.domain.Post;
import com.ubit.hibernate.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class HomeController {

    PostRepository postRepository;

    public HomeController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String indexAction(Model model){

        Set<Post> posts = postRepository.findAll();

        model.addAttribute("posts",posts);

        return "index";

    }

    @RequestMapping(value = "/index2",method = RequestMethod.GET)
    public String index2Action(Model model){

        Optional<Post> optionalPost =  postRepository.findByDescription("desc");

        if (!optionalPost.isPresent())
            throw new RuntimeException("bu yok");

        model.addAttribute("posts",optionalPost.get());

        return "index";
    }

    @GetMapping("/index3/{id}")
    public String index3Action(@PathVariable("id")Long id, Model model){

        Optional<Post> optionalPost = postRepository.findById(id);

        if (!optionalPost.isPresent())
            throw new RuntimeException("bu yok");

        model.addAttribute("posts",optionalPost.get());

        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteAction(@PathVariable("id")Long id, Model model){

        postRepository.deleteById(id);

        return "redirect:/index";

    }
}


