package com.comrade.service;

import com.comrade.domine.TopicTypeEntity;
import com.comrade.model.CommonResponse;
import com.comrade.model.TopicTypeModel;
import com.comrade.model.exception.RecordNotFoundException;
import com.comrade.repo.TopicTypeRepository;
import com.comrade.utils.DcConstants;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class TopicTypeServiceImpl implements TopicTypeService{
    private final TopicTypeRepository topicTypeRepository;

    public TopicTypeServiceImpl(TopicTypeRepository topicTypeRepository) {
        this.topicTypeRepository = topicTypeRepository;
    }

    @Override
    @Transactional
    public TopicTypeEntity save(TopicTypeModel topicTypeModel) {
        TopicTypeEntity topicTypeEntity=new TopicTypeEntity();
        BeanUtils.copyProperties(topicTypeModel,topicTypeEntity);
        return topicTypeRepository.saveAndFlush(topicTypeEntity);
    }

    @Override
    @Transactional
    public List<TopicTypeEntity> getAll() {

        return topicTypeRepository.findAll();
    }

    @Override
    public CommonResponse deleteByTopicTypeId(Integer topicTypeId) {
        topicTypeRepository.findById(topicTypeId).ifPresentOrElse(topicTypeRepository::delete,()-> {throw new RecordNotFoundException(DcConstants.TOPIC_TYPE_NOT_FOUND);});
        return  CommonResponse.builder().message(DcConstants.TOPIC_TYPE_DELETED).statusCode(204).timeStamp(new Date()).build();
    }
}
