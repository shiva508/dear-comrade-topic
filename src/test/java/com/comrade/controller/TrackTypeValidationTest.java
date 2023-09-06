package com.comrade.controller;

import com.comrade.model.TopicTypeModel;
import jakarta.validation.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class TrackTypeValidationTest {
    private static Validator validator;
    @BeforeAll
    public static void init(){
        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        validator=validatorFactory.getValidator();
    }

    @Test
    public void whenAllFieldsHasValidData(){
        TopicTypeModel topicTypeModel=new TopicTypeModel();
        topicTypeModel.setTopicTypeId(10);
        topicTypeModel.setTopicTypeName("Java");
        Set<ConstraintViolation<TopicTypeModel>> violations = validator.validate(topicTypeModel);
        Assertions.assertThat(violations).isEmpty();
    }

    @Test
    public void whenAllFieldsHasInValidData(){
        TopicTypeModel topicTypeModel=new TopicTypeModel();
        topicTypeModel.setTopicTypeId(10);
        topicTypeModel.setTopicTypeName("");
        Set<ConstraintViolation<TopicTypeModel>> violations = validator.validate(topicTypeModel);
        Assertions.assertThat(violations).hasSize(1);
    }
}
