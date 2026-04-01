package io.janbalangue.jbsite.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.time.Year;
import java.util.Locale;
import java.util.Map;

@Component
public class ColdStartWarmup {
    private static final Logger log = LoggerFactory.getLogger(ColdStartWarmup.class);

    private static final Map<String, Object> STATS = Map.of(
    );

    private final SpringTemplateEngine templateEngine;

    public ColdStartWarmup(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void warm() {
        boolean enabled = "true".equalsIgnoreCase(System.getenv("ENABLE_WARMUP"));
        if (!enabled) return;
        try {
            // Warm the templates you actually render
            render("index");
            render("fragments/music");
            render("fragments/writing");
            render("fragments/software");
            log.info("Cold start warmup complete");
        } catch (Exception e) {
            // Never fail startup for warmup.
            log.warn("Cold start warmup skipped: {}", e.toString());
        }
    }

    private void render(String viewName) {
        Context ctx = new Context(Locale.US);
        ctx.setVariable("year", Year.now().getValue());
        ctx.setVariable("stats", STATS);

        // process() parses/compiles and fills caches; output is discarded.
        templateEngine.process(viewName, ctx);
    }
}
