package com.web.xpertview.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.xpertview.dto.request.CoachingRequest;
import com.web.xpertview.dto.request.TrainingRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@Slf4j
@SpringBootTest
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper= new ObjectMapper();
    @Test
    void testContactRequestWithInvalidDetailsFailed() throws Exception{
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/xpertview/contact")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(TrainingRequest.builder()
                                    .message("")
                                    .build())))
                    .andExpect(status().is4xxClientError())
                    .andDo(print());
    }
    @Test
    void testContactRequest() throws Exception {
                    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/xpertview/contact")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(
                                    new TrainingRequest("+2341234567890",
                                            "senior man","normal"))))
                    .andExpect(status().isOk())
                    .andDo(print());

    }
    @Test
    void testCoachingRequest() throws Exception{
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/xpertview/bookCoaching")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(CoachingRequest.builder()
                                    .proposedDate(LocalDate.parse("2007-12-03"))
                                    .message("mosllwek")
                                    .fullName("name kals")
                                    .phoneNumber("+2340123456789")
                                    .build())))
                    .andExpect(status().isOk())
                    .andDo(print());
    }
    @Test
    void testCoachingRequestWithInvalidDetailsFails() throws Exception{
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/xpertview/contact")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(TrainingRequest.builder()
                                            .fullName("")
                                            .build())))
                    .andExpect(status().is4xxClientError())
                    .andDo(print());
    }
    @Test
    void testTrainingRequestWithInvalidDetailsFails() throws Exception{
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/xpertview/bookTraining")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(TrainingRequest.builder()
                                    .phoneNumber("901")
                                    .message("").build())))
                    .andExpect(status().is4xxClientError())
                    .andDo(print());
    }
    @Test
    void testTrainingRequest() throws Exception{
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/xpertview/bookTraining")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(TrainingRequest.builder()
                                    .phoneNumber("12908394123")
                                    .fullName("Abbey laso")
                                    .message("nothing much").build())))
                    .andExpect(status().isOk())
                    .andDo(print());
    }
}
