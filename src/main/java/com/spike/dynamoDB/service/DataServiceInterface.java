package com.spike.dynamoDB.service;

import com.spike.dynamoDB.entity.Notification;
import com.spike.dynamoDB.entity.DynamoDBDataDTO;

public interface DataServiceInterface {
    Iterable<Notification> findAll()  throws Exception;
    void saveItem(DynamoDBDataDTO dto)  throws Exception;
}
