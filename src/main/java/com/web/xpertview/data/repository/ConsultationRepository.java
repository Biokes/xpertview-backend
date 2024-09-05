package com.web.xpertview.data.repository;

import com.web.xpertview.data.models.Consultation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsultationRepository extends MongoRepository<Consultation, String> {
}
