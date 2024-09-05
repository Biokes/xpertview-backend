package com.web.xpertview.data.repository;


import com.web.xpertview.data.models.Coachee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoachRepository extends MongoRepository<Coachee, String> {
}
