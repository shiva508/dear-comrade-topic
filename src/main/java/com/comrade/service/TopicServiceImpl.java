package com.comrade.service;

import com.comrade.domine.TopicEntity;
import com.comrade.model.CommonResponse;
import com.comrade.model.exception.RecordNotFoundException;
import com.comrade.repo.TopicRepository;
import com.comrade.utils.DcConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService{

    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    @Transactional
    public TopicEntity save(TopicEntity topicEntity) {
        return topicRepository.save(topicEntity);
    }

    @Override
    @Transactional
    public List<TopicEntity> getAll() {
        return topicRepository.findAll();
    }

    @Override
    @Transactional
    public List<TopicEntity> findByTopicType(String topicType) {
        return topicRepository.findByTopicType(topicType);
    }

    @Override
    @Transactional
    public TopicEntity update(TopicEntity topicEntity) {
        return topicRepository.saveAndFlush(topicEntity);
    }

    @Override
    public CommonResponse delete(Integer topicId) {
        TopicEntity topicEntity = topicRepository.findById(topicId).orElseThrow(() -> new RecordNotFoundException(DcConstants.TOPIC_NOT_FOUND));
        topicRepository.delete(topicEntity);
        return CommonResponse.builder().message(DcConstants.TOPIC_DELETED).statusCode(204).timeStamp(new Date()).build();
    }
}
