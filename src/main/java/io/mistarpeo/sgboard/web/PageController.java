package io.mistarpeo.sgboard.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PageController {

    @GetMapping("/category")
    public String category(Model model) {
        model.addAttribute("title", "Category - ");
        return "category";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About - ");
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contact - ");
        return "contact";
    }

    @GetMapping("/single-audio")
    public String singleAudio(Model model) {
        model.addAttribute("title", "Audio Post - ");
        return "single-audio";
    }

    @GetMapping("/single-standard")
    public String singleStandard(Model model) {
        model.addAttribute("title", "Standard Post - ");
        return "single-standard";
    }

    @GetMapping("/single-video")
    public String abousingleVideo(Model model) {
        model.addAttribute("title", "Video Post - ");
        return "single-video";
    }

    @GetMapping("/styles")
    public String styles(Model model) {
        model.addAttribute("title", "Style Guide - ");
        return "styles";
    }
}
