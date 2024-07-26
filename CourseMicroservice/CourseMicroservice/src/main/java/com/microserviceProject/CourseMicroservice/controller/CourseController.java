package com.microserviceProject.CourseMicroservice.controller;

import com.microserviceProject.CourseMicroservice.client.FullResponse;
import com.microserviceProject.CourseMicroservice.model.Course;
import com.microserviceProject.CourseMicroservice.service.CourseService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
        public List<Course> addcourses(@RequestBody List<Course> courses){
            return courseService.addCourses(courses);
        }

    @GetMapping("/getById/{courseId}")
    public FullResponse getCourseById(@PathVariable("courseId") String courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/getCourseByUserId/{userId}")
    public List<Course> getCourseByUserId(@PathVariable("userId") String userId){
        return courseService.getCourseByUserId(userId);
    }

}
