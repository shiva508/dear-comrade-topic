package com.comrade.controller;

import com.comrade.model.TopicTypeModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TopicTypeControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void addNewTopicTypeTest(){
        TopicTypeModel topicTypeModel=new TopicTypeModel();
        topicTypeModel.setTopicTypeId(10);
        topicTypeModel.setTopicTypeName("Java");
        webTestClient
                .post()
                .uri("/api/topictype/save")
                .bodyValue(topicTypeModel)
                .exchange()
                .expectStatus().isCreated();
    }
}
