package com.microServiceProject.AssessmentService.controller;

import com.microServiceProject.AssessmentService.client.FullRepsonse;
import com.microServiceProject.AssessmentService.model.Assessment;
import com.microServiceProject.AssessmentService.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessment")
public class AssessmentController {
    @Autowired
    private AssessmentService assessmentService;

    @PostMapping("/addAssessment")
    public Assessment addAssessment(@RequestBody Assessment assessment){
        return assessmentService.addAssessment(assessment);
    }

    @GetMapping("/getById/{assessmentId}")
    public FullRepsonse getAssessmentById(@PathVariable("assessmentId") String assessmentId){
        return assessmentService.getbyAssessmentId(assessmentId);
    }

    @GetMapping("/getByCourseId/{courseID}")
    public List<Assessment> getAssessmentByCourseId(@PathVariable("courseID") String courseID){
        return assessmentService.getByCourseId(courseID);
    }

}
