package com.microserviceProject.CourseMicroservice.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assessment {
    public String assessmentId;
    public String assessmentName;
    public String assessmentDescription;
    public String assessmentType;
    public String assessmentDuration;
    public String courseID;
    public String resultID;
    public List<ResultModel> results;
}
