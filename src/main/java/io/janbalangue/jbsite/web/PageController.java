package io.janbalangue.jbsite.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Year;
import java.util.Map;


@Controller
public class PageController {

    private static final Map<String, Object> STATS = Map.of(
            "soundcloudFollowers", "1.3K",
            "substackSubscribers", 320,
            "substackFollowers", "1.5K",
            "substackSince", "Oct 2025",
            "youtubeSubscribers", "4.8K",
            "youtubeSince", "Dec 2025",
            "bulkheadVersion", "v0.5.2",
            "tsBulkheadVersion", "v0.2.2"
    );

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("year", Year.now().getValue());
        model.addAttribute("stats", STATS);
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
}
