package com.spike.dynamoDB.controller;

import com.spike.dynamoDB.entity.Notification;
import com.spike.dynamoDB.entity.DynamoDBDataDTO;
import com.spike.dynamoDB.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/data")
public class DataController {

    @Autowired
    private DataService dataService;


    @GetMapping()
    public ResponseEntity<Iterable<Notification>> findAll(){
        return new ResponseEntity<>(dataService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody DynamoDBDataDTO dto) {
        dataService.saveItem(dto);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping(path = "/cuit")
    public ResponseEntity<Iterable<Notification>> findByCuit(@RequestParam Long cuit){
        return new ResponseEntity<>(dataService.findByCuit(cuit), HttpStatus.OK);
    }
}
