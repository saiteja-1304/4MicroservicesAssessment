package com.microserviceProject.CourseMicroservice.feign;

import com.microserviceProject.CourseMicroservice.client.Assessment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="AssessmentService",url="http://localhost:9101/assessment")
public interface AssessmentClient {
    @GetMapping("/getByCourseId/{courseID}")
    public List<Assessment> getAssessmentByCourseId(@PathVariable("courseID") String courseID);
}
