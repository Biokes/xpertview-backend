package com.web.xpertview.services.implementation;

import com.web.xpertview.data.models.Consultation;
import com.web.xpertview.data.repository.ConsultationRepository;
import com.web.xpertview.dto.out.CoachingResponse;
import com.web.xpertview.dto.out.Response;
import com.web.xpertview.dto.request.CoachingRequest;
import com.web.xpertview.dto.request.TrainingRequest;
import com.web.xpertview.data.models.Coachee;
import com.web.xpertview.data.models.Training;
import com.web.xpertview.data.repository.CoachRepository;
import com.web.xpertview.data.repository.TrainingRepository;
import com.web.xpertview.services.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class XpertService implements UserService {
    private final ModelMapper modelMapper;
    private final TrainingRepository trainingRepo;
    private final CoachRepository coachingRepo;
    private final ConsultationRepository consultationRepository;
    @Autowired
    public XpertService(ModelMapper modelMapper, ConsultationRepository contactRepo,
                        TrainingRepository trainingRepo, CoachRepository coachRepo){
        this.modelMapper= modelMapper;
        consultationRepository= contactRepo;
        this.trainingRepo= trainingRepo;
        this.coachingRepo= coachRepo;
    }
    @Override
    @Transactional
    public Response bookTraining(@Valid TrainingRequest trainingRequest) {
        Training training = modelMapper.map(trainingRequest, Training.class);
        training = trainingRepo.save(training);
        return modelMapper.map(training, Response.class);
    }
    @Override
    public CoachingResponse bookCoaching(@Valid CoachingRequest request) {
        Coachee coaching = modelMapper.map(request, Coachee.class);
        coaching = coachingRepo.save(coaching);
        return modelMapper.map(coaching, CoachingResponse.class);
    }
    @Override
    public Response contact(TrainingRequest request) {
        Consultation contact = modelMapper.map(request,Consultation.class);
        contact=consultationRepository.save(contact);
        return modelMapper.map(contact,Response.class);
    }
}
