package com.spike.dynamoDB.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DynamoDBDataDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long cuit;
    private Long userId;
    private String notificationType;
    private String link;
    private LocalDateTime linkExpirationDate;
    private Boolean read;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//    private LocalDateTime deletedAt;
//    private String title;
//    private String body;
//    private String urlText;
//    private String from;
//    private String user;


}
