package com.web.xpertview.services;

import com.web.xpertview.dto.out.CoachingResponse;
import com.web.xpertview.dto.out.Response;
import com.web.xpertview.dto.request.CoachingRequest;
import com.web.xpertview.dto.request.TrainingRequest;
import com.web.xpertview.services.service.UserService;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Slf4j
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    void testUserCanTrain(){
        TrainingRequest trainingRequest= TrainingRequest.builder().build();
        assertThrows(ConstraintViolationException.class,()->userService.bookTraining(trainingRequest));
        trainingRequest.setMessage("message");
        trainingRequest.setFullName("full name");
        trainingRequest.setPhoneNumber("+1230123456789");
        Response response = userService.bookTraining(trainingRequest);
        assertNotNull(response);
        log.info("Response 1 ----------------->{}", response);

    }
    @Test
    void userCanBookCoaching(){
        CoachingRequest coachingRequest= CoachingRequest.builder().build();
        assertThrows(ConstraintViolationException.class,()->userService.bookCoaching(coachingRequest));
        coachingRequest.setMessage("message");
        coachingRequest.setFullName("full name");
        coachingRequest.setProposedDate(LocalDate.parse("2007-01-18"));
        coachingRequest.setPhoneNumber("320123456789");
        CoachingResponse response = userService.bookCoaching(coachingRequest);
        assertNotNull(response);

        log.info("Response 2 ----------------->{}", response);
    }
    @Test
    void testUserCanContact(){
        TrainingRequest trainingRequest= TrainingRequest.builder().build();
        assertThrows(ConstraintViolationException.class,()->userService.contact(trainingRequest));
        trainingRequest.setMessage("message");
        trainingRequest.setFullName("full name");
        trainingRequest.setPhoneNumber("320123456789");
        Response response = userService.contact(trainingRequest);
        assertNotNull(response);
        log.info("Response 3 ----------------->{}", response);

    }
}
