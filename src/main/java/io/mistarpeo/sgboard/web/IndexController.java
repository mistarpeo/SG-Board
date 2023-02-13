package io.mistarpeo.sgboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@Controller
public class IndexController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping(value="/posts/save")
    public String postsSave() {
        return "posts-save";
    }
    
    
}
