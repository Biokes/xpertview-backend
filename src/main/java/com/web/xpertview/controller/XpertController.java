package com.web.xpertview.controller;

import com.web.xpertview.dto.request.CoachingRequest;
import com.web.xpertview.dto.request.TrainingRequest;
import com.web.xpertview.services.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/xpertview")
public class XpertController {

    private final UserService userService;
    @Autowired
    public XpertController(UserService xpertService){
        this.userService = xpertService;
    }
    @PostMapping("/bookTraining")
    public ResponseEntity<?> bookTraining(@RequestBody TrainingRequest request){
        return ResponseEntity.status(200).body(userService.bookTraining(request));
    }
    @PostMapping("/bookCoaching")
    public ResponseEntity<?> bookCoaching(@RequestBody CoachingRequest request){
        return ResponseEntity.status(200).body(userService.bookCoaching(request));
    }
    @PostMapping("/contact")
    public ResponseEntity<?> contact(@RequestBody TrainingRequest request){
        return ResponseEntity.status(200).body(userService.contact(request));
    }
}
