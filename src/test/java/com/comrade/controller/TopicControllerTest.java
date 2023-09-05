package com.comrade.controller;

import com.comrade.domine.TopicEntity;
import com.comrade.service.TopicService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TopicController.class)
public class TopicControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TopicService topicService;

    //@Test
    public void save() throws Exception {
        TopicEntity topicEntity=new TopicEntity();
        topicEntity.setTopicId(1);
        topicEntity.setTopicName("What is Java");
        topicEntity.setTopicType("Java");
        BDDMockito.given(topicService.save(topicEntity)).willReturn(topicEntity);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(topicEntity);
        mockMvc.perform(post("/api/topic/save").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().is2xxSuccessful());
    }
}
