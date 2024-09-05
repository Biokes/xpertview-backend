package com.web.xpertview.services.service;

import com.web.xpertview.dto.out.CoachingResponse;
import com.web.xpertview.dto.out.Response;
import com.web.xpertview.dto.request.CoachingRequest;
import com.web.xpertview.dto.request.TrainingRequest;
import jakarta.validation.Valid;

public interface UserService {
    Response bookTraining(@Valid TrainingRequest trainingRequest);
    CoachingResponse bookCoaching(@Valid CoachingRequest trainingRequest);
    Response contact(@Valid TrainingRequest trainingRequest);
}
