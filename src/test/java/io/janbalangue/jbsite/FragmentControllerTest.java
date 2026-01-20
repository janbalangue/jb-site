package io.janbalangue.jbsite;

import io.janbalangue.jbsite.web.PageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PageController.class)
class FragmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void musicFragmentLoads() throws Exception {
        mockMvc.perform(get("/fragments/music"))
                .andExpect(status().isOk())
                .andExpect(view().name("fragments/music"));
    }

    @Test
    void writingFragmentLoads() throws Exception {
        mockMvc.perform(get("/fragments/writing"))
                .andExpect(status().isOk())
                .andExpect(view().name("fragments/writing"));
    }

    @Test
    void ossFragmentLoads() throws Exception {
        mockMvc.perform(get("/fragments/oss"))
                .andExpect(status().isOk())
                .andExpect(view().name("fragments/oss"));
    }
}

