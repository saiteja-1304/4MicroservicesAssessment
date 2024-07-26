package com.microServicesProject.UserMicroservice.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullResponse {
    private String userId;
    private String name;
    private String email;
    private String courseId;
    private String education;
    public List<Course> courses;

}
