package com.spike.dynamoDB.controller;

import com.spike.dynamoDB.entity.DynamoDBData;
import com.spike.dynamoDB.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/data")
public class DataController {

    @Autowired
    private DataService dataService;


    @GetMapping()
    public ResponseEntity<Iterable<DynamoDBData>> findAll(){
        return new ResponseEntity<>(dataService.findAll(), HttpStatus.OK);
    }

//    @PostMapping()
//    public ResponseEntity<String> createItem(){
//        dataService.createItem();
//        return new ResponseEntity<>("ok", HttpStatus.OK);
//    }




}
