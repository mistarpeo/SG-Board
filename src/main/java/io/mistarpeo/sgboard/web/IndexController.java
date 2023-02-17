package io.mistarpeo.sgboard.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.mistarpeo.sgboard.service.posts.PostsService;
import io.mistarpeo.sgboard.web.dto.PostsResponseDto;
// import jakarta.servlet.http.HttpSession;
import io.mistarpeo.sgboard.config.auth.LoginUser;
import io.mistarpeo.sgboard.config.auth.dto.SessionUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    // private final HttpSession httpSession;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "");
        return "index";
    }

    @GetMapping("/_index")
    public String _index(Model model, @LoginUser SessionUser user ) {
        model.addAttribute("posts", postsService.findAllDesc());
        // SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "_index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

}
