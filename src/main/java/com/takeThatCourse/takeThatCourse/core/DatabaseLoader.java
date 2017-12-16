package com.takeThatCourse.takeThatCourse.core;

import com.takeThatCourse.takeThatCourse.model.Course;
import com.takeThatCourse.takeThatCourse.model.CourseRepository;
import com.takeThatCourse.takeThatCourse.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final CourseRepository courseRepository;

    @Autowired

    public DatabaseLoader(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        Course course = new Course("React course", "https://teamtreehouse.com/library/react-fundamentals");
        Course course2 = new Course("Angular foundations", "https://teamtreehouse.com/library/angular-fundamentals");
        Course course3 = new Course("Ionic: getting started", "https://teamtreehouse.com/library/ionic-fundamentals");
        course.addReview(new Review(2,"Fairly good !"));
        course2.addReview(new Review(4,"A very nice course !"));
        course3.addReview(new Review(1,"A bad course !"));
        courseRepository.save(course);
        courseRepository.save(course2);
        courseRepository.save(course3);
    }
}
