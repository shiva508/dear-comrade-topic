package com.comrade.controller;

import com.comrade.domine.TopicTypeEntity;
import com.comrade.model.CommonResponse;
import com.comrade.model.TopicTypeModel;
import com.comrade.service.TopicTypeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/topictype")
public class TopicTypeController {

    private final TopicTypeService topicTypeService;

    public TopicTypeController(TopicTypeService topicTypeService) {
        this.topicTypeService = topicTypeService;
    }

    @PostMapping("/save")
    public TopicTypeEntity save(@Valid @RequestBody TopicTypeModel topicTypeModel){
        return topicTypeService.save(topicTypeModel);
    }

    @GetMapping("/all")
    public List<TopicTypeEntity> getAll(){
        return topicTypeService.getAll();
    }

    @DeleteMapping("/delete/{topicTypeId}")
    public CommonResponse deleteByTopicTypeId(@PathVariable("topicTypeId") Integer topicTypeId){
        return topicTypeService.deleteByTopicTypeId(topicTypeId);
    }
}
