package io.janbalangue.jbsite.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // HTMX fragment routes
    @GetMapping("/fragments/music")
    public String music() {
        return "fragments/music";
    }

    @GetMapping("/fragments/writing")
    public String writing() {
        return "fragments/writing";
    }

    @GetMapping("/fragments/software")
    public String software() {
        return "fragments/software";
    }
}