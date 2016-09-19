package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRestProblemApplicationTests {

    private static final MediaType MEDIA_TYPE = MediaType.parseMediaType("application/hal+json;charset=UTF-8");

    private MockMvc mockMvc;

    @Resource
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void contextLoads() throws Exception {
        mockMvc.perform(get("/productEntities").accept(MEDIA_TYPE).contentType(MEDIA_TYPE)).andDo(print()).andExpect(status().isOk()).andExpect(
                        jsonPath("$._embedded.productEntities[0].test", equalTo("test"))).andDo(print());

    }

}
