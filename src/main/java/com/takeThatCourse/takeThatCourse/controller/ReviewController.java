package com.takeThatCourse.takeThatCourse.controller;

import com.takeThatCourse.takeThatCourse.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;
    @RequestMapping(value = "/allReviews", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getReviews(ModelMap modelMap) {
        List<Course> courseList = (List<Course>) courseRepository.findAll();
        Map<Course, List<Review>> coursesReviews = new HashMap<>();
        for (Course c : courseList) {
            if (c.getReviewList().size() > 0)
                coursesReviews.put(c, c.getReviewList());
        }
        modelMap.put("allReviews", coursesReviews);
        return "showAllReviews";
    }

    @RequestMapping(value = "/addReview", method = RequestMethod.POST)

    public String submit(@Valid @ModelAttribute("review") Review review,
                         BindingResult result, ModelMap model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ApplicationUser applicationUser = applicationUserRepository.findByUserName(user.getUsername());
        if (result.hasErrors()) {
            return "error";
        }
        if (review.getCourse() != null)
            courseRepository.save(review.getCourse());
        review.setReviewer(applicationUser);
        reviewRepository.save(review);

        return "redirect:/allReviews";
    }

}
