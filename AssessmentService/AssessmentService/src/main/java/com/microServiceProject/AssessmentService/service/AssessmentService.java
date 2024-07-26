package com.microServiceProject.AssessmentService.service;

import com.microServiceProject.AssessmentService.Feign.ResultClient;
import com.microServiceProject.AssessmentService.client.FullRepsonse;
import com.microServiceProject.AssessmentService.client.ResultModel;
import com.microServiceProject.AssessmentService.model.Assessment;
import com.microServiceProject.AssessmentService.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private  AssessmentRepository repo;

    @Autowired
    private  ResultClient client;

    public Assessment addAssessment(Assessment assessment) {
       return repo.save(assessment);
    }

    public FullRepsonse getbyAssessmentId(String AssessmentId) {
        Assessment a = repo.findByAssessmentId(AssessmentId).orElse(null);
        List<ResultModel> list = client.getResultsByAssessmentId(AssessmentId);
        FullRepsonse res = new FullRepsonse();
        if(a!=null){
            res.setAssessmentId(a.getAssessmentId());
            res.setAssessmentDuration(a.getAssessmentDuration());
            res.setAssessmentType(a.getAssessmentType());
            res.setAssessmentName(a.getAssessmentName());
            res.setAssessmentDescription(a.getAssessmentDescription());
            res.setResults(list);
        }
        return res;
    }

    public List<Assessment> getByCourseId(String courseID) {
        return repo.findByCourseID(courseID);
    }
}
