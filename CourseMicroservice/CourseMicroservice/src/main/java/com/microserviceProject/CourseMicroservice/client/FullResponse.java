package com.microserviceProject.CourseMicroservice.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullResponse {
    public String courseId;
    public String courseName;
    public String courseDescription;
    public String userId;
    public String courseDuration;
    public String assessmentID;
    public List<Assessment> assessment;
}
