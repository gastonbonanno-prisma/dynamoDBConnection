package com.spike.dynamoDB.repository;

import com.spike.dynamoDB.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DataRepository {

    @Autowired
    DataRepositoryInterface dataRepositoryInterface;

    public Iterable<Notification> findAll(){
        return dataRepositoryInterface.findAll();
    }

    public Iterable<Notification> findByCuit(Long cuit){
        return dataRepositoryInterface.findByCuit(cuit);
    }

    public void save(Notification data){
        System.out.println("save data: "+data);
        dataRepositoryInterface.save(data);
    }

}
