package com.spike.dynamoDB.service;

import com.spike.dynamoDB.entity.DynamoDBData;

import java.util.List;

public interface DataServiceInterface {
    Iterable<DynamoDBData> findAll()  throws Exception;
//    void createItem()  throws Exception;
}
