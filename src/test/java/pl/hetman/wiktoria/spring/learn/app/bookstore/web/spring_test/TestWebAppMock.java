package pl.hetman.wiktoria.spring.learn.app.bookstore.web.spring_test;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestWebAppMock { //bez serwera, cały kontekst aplikacji springowej
//Another useful approach is to not start the server
// at all but to test only the layer below that, where
// Spring handles the incoming HTTP request and
// hands it off to your controller. That way, almost
// all of the full stack is used, and your code will be
// called in exactly the same way as if it were processing
// a real HTTP request but without the cost of starting the server.
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnString() throws Exception {
        //given
        String htmlString = "bookstore";

        //when
        ResultActions resultActions = this.mockMvc.perform(get("/books"))
                .andDo(print());

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(htmlString)));
    }
}
