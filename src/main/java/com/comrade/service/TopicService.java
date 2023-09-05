package com.comrade.service;

import com.comrade.domine.TopicEntity;
import com.comrade.model.CommonResponse;
import java.util.List;

public interface TopicService {
    public TopicEntity save(TopicEntity topicEntity);

    public List<TopicEntity> getAll();

    public List<TopicEntity> findByTopicType(String topicType);

    public TopicEntity update(TopicEntity topicEntity);

    public CommonResponse delete(Integer topicId);
}
