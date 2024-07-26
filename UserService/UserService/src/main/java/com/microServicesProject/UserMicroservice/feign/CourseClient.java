package com.microServicesProject.UserMicroservice.feign;

import com.microServicesProject.UserMicroservice.client.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CourseMicroservice",url="http://localhost:9102/course")
public interface CourseClient {
    @GetMapping("/getCourseByUserId/{userId}")
    public List<Course> getCourseByUserId(@PathVariable("userId") String userId);

}
