package com.comrade.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicTypeModel {
    private Integer topicTypeId;
    @NotBlank(message = "Topic type should not be empty or blank")
    private String topicTypeName;
}
