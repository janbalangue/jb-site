package io.janbalangue.jbsite.web;

import io.janbalangue.jbsite.config.SiteStats;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.Year;

/**
 * Adds commonly-needed model attributes to *every* Thymeleaf render
 * (full pages and HTMX fragments).
 */
@ControllerAdvice
public class GlobalModelAttributes {

    private final SiteStats stats;

    public GlobalModelAttributes(SiteStats stats) {
        this.stats = stats;
    }

    @ModelAttribute("stats")
    public SiteStats stats() {
        return stats;
    }

    @ModelAttribute("year")
    public int year() {
        return Year.now().getValue();
    }
}