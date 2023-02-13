package io.mistarpeo.sgboard.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PageController {

    @GetMapping("/category")
    public String category() {
         return "category";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/single-audio")
    public String singleAudio() {
        return "single-audio";
    }

    @GetMapping("/single-standard")
    public String singleStandard() {
        return "single-standard";
    }

    @GetMapping("/abosingle-video")
    public String abousingleVideo() {
        return "single-video";
    }

    @GetMapping("/styles")
    public String styles() {
        return "styles";
    }
}
