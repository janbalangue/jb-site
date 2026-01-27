package io.janbalangue.jbsite.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Year;
import java.util.Map;


@Controller
public class PageController {


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("year", Year.now().getValue());


// You can later replace these with values from application.yml or a JSON file.
        model.addAttribute("stats", Map.of(
                "substackSubscribers", 280,
                "substackSince", "Oct 2025",
                "youtubeSubscribers", 1190,
                "youtubeSince", "Dec 2025",
                "bulkheadVersion", "v0.4.0",
                "tsBulkheadVersion", "v0.2.0"
        ));


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


    @GetMapping("/fragments/oss")
    public String oss() {
        return "fragments/oss";
    }


    // Optional: tiny health endpoint
    @GetMapping("/health")
    @ResponseBody
    public String health() {
        return "ok";
    }
}
