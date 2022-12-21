package com.spike.dynamoDB.service;

import com.spike.dynamoDB.entity.DynamoDBData;
import com.spike.dynamoDB.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService implements DataServiceInterface {

    @Autowired
    public DataRepository dataRepository;

    public Iterable<DynamoDBData> findAll(){
        return dataRepository.findAll();
    }

//    public void createItem(){
//        dataRepository.createItem();
//    }

}
