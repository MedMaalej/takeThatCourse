package com.takeThatCourse.takeThatCourse.controller;

import com.takeThatCourse.takeThatCourse.model.Course;
import com.takeThatCourse.takeThatCourse.model.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;
    @RequestMapping("/")
    public String getHome(ModelMap modelMap) {
        List<Course> courseList = (List<Course>) courseRepository.findAll();
        modelMap.put("courses",courseList);
        return "index";
    }
    @RequestMapping("/courses")
    @ResponseBody
    public List<Course> getCourses() {
        return (List<Course>)courseRepository.findAll();
    }
}
