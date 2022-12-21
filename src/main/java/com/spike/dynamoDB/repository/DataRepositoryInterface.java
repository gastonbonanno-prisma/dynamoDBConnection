package com.spike.dynamoDB.repository;

import com.spike.dynamoDB.entity.DynamoDBData;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableScan
@Repository
public interface DataRepositoryInterface extends CrudRepository<DynamoDBData, String> {

//    Optional<DynamoDBData> findById(String id);


}
