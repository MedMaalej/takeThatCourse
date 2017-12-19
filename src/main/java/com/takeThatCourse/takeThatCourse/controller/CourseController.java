package com.takeThatCourse.takeThatCourse.controller;

import com.takeThatCourse.takeThatCourse.model.Course;
import com.takeThatCourse.takeThatCourse.model.CourseRepository;
import com.takeThatCourse.takeThatCourse.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;
    @RequestMapping("/")
    public String getHome(ModelMap modelMap) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Course> courseList = (List<Course>) courseRepository.findAll();
        List<Course> unratedCourses = new ArrayList<>();
        for(Course course: courseList) {
            boolean found = false;
            for(Review review: course.getReviewList()) {

                if(review.getReviewer().getUserName().equals(user.getUsername())){
                    found = true;
                }

            }
            if(!found) {
                unratedCourses.add(course);
            }
        }
        modelMap.put("review",new Review());
        modelMap.put("courses",unratedCourses);
        return "index";
    }
    @RequestMapping("/courses")
    @ResponseBody
    public List<Course> getCourses() {
        return (List<Course>)courseRepository.findAll();
    }
}
