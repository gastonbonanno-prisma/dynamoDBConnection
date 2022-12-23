package com.spike.dynamoDB.repository;

import com.spike.dynamoDB.entity.Notification;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableScan
@Repository
public interface DataRepositoryInterface extends CrudRepository<Notification, String> {
    Iterable<Notification> findByCuit(Long cuit);
}
