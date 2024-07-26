package com.microServiceProject.AssessmentService.client;

//import org.springframework.cloud.openfeign.FeignClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullRepsonse {
    public String assessmentId;
    public String assessmentName;
    public String assessmentDescription;
    public String assessmentType;
    public String assessmentDuration;
    //public String resultID;
    public List<ResultModel> results;
}
