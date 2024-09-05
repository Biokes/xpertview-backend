package com.web.xpertview.data.repository;


import com.web.xpertview.data.models.Training;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface TrainingRepository extends MongoRepository<Training,String> {
}
