package com.microserviceProject.CourseMicroservice.service;

import com.microserviceProject.CourseMicroservice.client.FullResponse;
import com.microserviceProject.CourseMicroservice.client.Assessment;
import com.microserviceProject.CourseMicroservice.feign.AssessmentClient;
import com.microserviceProject.CourseMicroservice.model.Course;
import com.microserviceProject.CourseMicroservice.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CourseService {
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private AssessmentClient client;

    public List<Course> addCourses(List<Course> courses) {
        return courseRepo.saveAll(courses);
    }

    public FullResponse getCourseById(String CourseId) {
        Course c = courseRepo.findByCourseId(CourseId).orElse(null);
        List<Assessment> list = client.getAssessmentByCourseId(CourseId);
        FullResponse res = new FullResponse();
        res.setCourseId(c.getCourseId());
        res.setCourseName(c.getCourseName());
        res.setCourseDescription(c.getCourseDescription());
        res.setCourseDuration(c.getCourseDuration());
        res.setAssessmentID(c.getAssessmentID());
        res.setAssessment(list);

        return res;
    }

    public List<Course> getCourseByUserId(String userId) {
        return courseRepo.findByUserId(userId);
    }
}
