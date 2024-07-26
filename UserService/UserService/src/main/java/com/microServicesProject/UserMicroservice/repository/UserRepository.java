package com.microServicesProject.UserMicroservice.repository;

import com.microServicesProject.UserMicroservice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    List<UserModel> findByCourseId(String courseId);

    List<UserModel> findByAssessmentId(String assignmentId);

    //List<UserModel> findById(String userId);

    UserModel findByUserId(String userId);
}
