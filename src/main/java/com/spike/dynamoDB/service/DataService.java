package com.spike.dynamoDB.service;

import com.spike.dynamoDB.Dynamo.DynamoConnection;
import com.spike.dynamoDB.entity.Notification;
import com.spike.dynamoDB.entity.DynamoDBDataDTO;
import com.spike.dynamoDB.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataService {

    @Autowired
    public DataRepository dataRepository;

    @Autowired
    public DynamoConnection dynamoConnection;

    public Iterable<Notification> findAll(){
        return dataRepository.findAll();
    }

    public Iterable<Notification> findByCuit(Long cuit){
        return dataRepository.findByCuit(cuit);
    }

    public void saveItem(DynamoDBDataDTO dto){
        Notification notification = new Notification();
        notification.setCuit(dto.getCuit());
        notification.setUserId(dto.getUserId());
        notification.setNotificationType(dto.getNotificationType());
        notification.setLink(dto.getLink());
        notification.setLinkExpirationDate(dto.getLinkExpirationDate());
        notification.setRead(dto.getRead());

        dataRepository.save(notification);
    }


}
