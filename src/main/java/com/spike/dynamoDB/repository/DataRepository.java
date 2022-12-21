package com.spike.dynamoDB.repository;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.spike.dynamoDB.Dynamo.DynamoConnection;
import com.spike.dynamoDB.entity.DynamoDBData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {

//    @Autowired
//    private DynamoConnection dynamoConnection;
//
//
//    public String findAll(){
//        return dynamoConnection.retrieveItem();
//    }
//
//    public void createItem(){
//        dynamoConnection.createItem();
//    }

    @Autowired
    DataRepositoryInterface dataRepositoryInterface;

    public Iterable<DynamoDBData> findAll(){
        return dataRepositoryInterface.findAll();
    }



}
