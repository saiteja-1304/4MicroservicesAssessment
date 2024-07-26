package com.microServicesProject.UserMicroservice.service;

import com.microServicesProject.UserMicroservice.client.Course;
import com.microServicesProject.UserMicroservice.client.FullResponse;
//import com.microServicesProject.UserMicroservice.dto.UserDto;
import com.microServicesProject.UserMicroservice.feign.CourseClient;
import com.microServicesProject.UserMicroservice.model.UserModel;
import com.microServicesProject.UserMicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseClient client;

    //    public UserModel addUser(UserDto userdto) {
//        UserModel userModel = UserModel.builder()
//        .userId(userdto.getUserId())
//        .name(userdto.getName())
//        .email(userdto.getEmail())
//                .course(userdto.getCourse())
//                .courseId(userdto.getCourseId())
//                .education(userdto.getEducation())
//                .assessmentId(userdto.getAssessmentId())
//                .assessmentName(userdto.getAssessmentName())
//                .build();
//        return userRepository.save(userModel);
    //   }
    public UserModel addUser(UserModel user) {
        return userRepository.save(user);
    }

//        public List<UserModel> getByCourseId (String courseId){
//            return userRepository.findByCourseId(courseId);
//        }
//
//        public List<UserModel> getByAssessmentId (String assessmentId){
//            return userRepository.findByAssessmentId(assessmentId);
//        }

    public FullResponse getByUserId(String UserId) {
        UserModel u = userRepository.findByUserId(UserId);
        List<Course> list = client.getCourseByUserId(UserId);
        FullResponse res = new FullResponse();
        res.setUserId(u.getUserId());
        res.setName(u.getName());
        res.setEmail(u.getEmail());
        res.setCourseId(u.getCourseId());
        res.setEducation(u.getEducation());
        res.setCourses(list);
        return res;
    }
}