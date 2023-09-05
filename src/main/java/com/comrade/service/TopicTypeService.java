package com.comrade.service;

import com.comrade.domine.TopicTypeEntity;
import com.comrade.model.CommonResponse;
import com.comrade.model.TopicTypeModel;

import java.util.List;

public interface TopicTypeService {
    public TopicTypeEntity save(TopicTypeModel topicTypeModel);

    public List<TopicTypeEntity> getAll();

    public CommonResponse deleteByTopicTypeId(Integer topicTypeId);
}
