package com.microServicesProject.UserMicroservice.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    public String courseId;
    public String courseName;
    public String courseDescription;
    public String userId;
    public String courseDuration;
    public String assessmentID;
    public List<Assessment> assessments;
}
