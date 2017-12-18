package com.takeThatCourse.takeThatCourse.controller;

import com.takeThatCourse.takeThatCourse.model.Course;
import com.takeThatCourse.takeThatCourse.model.CourseRepository;
import com.takeThatCourse.takeThatCourse.model.Review;
import com.takeThatCourse.takeThatCourse.model.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;
    @RequestMapping(value = "/reviews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Review> getCourses() {
        return (List<Review>)reviewRepository.findAll();
    }
}
