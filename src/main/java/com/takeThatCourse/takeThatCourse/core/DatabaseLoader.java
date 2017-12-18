package com.takeThatCourse.takeThatCourse.core;

import com.takeThatCourse.takeThatCourse.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final CourseRepository courseRepository;
    private final ApplicationUserRepository applicationUserRepository;

    @Autowired

    public DatabaseLoader(CourseRepository courseRepository, ApplicationUserRepository applicationUserRepository) {
        this.courseRepository = courseRepository;
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
      /*  Course course = new Course("React course", "https://teamtreehouse.com/library/react-fundamentals");
        Course course2 = new Course("Angular foundations", "https://teamtreehouse.com/library/angular-fundamentals");
        Course course3 = new Course("Ionic: getting started", "https://teamtreehouse.com/library/ionic-fundamentals");
        Review review = new Review(2, "Fairly good !");

        Review review1 = new Review(4, "A very nice course !");
        Review review2 = new Review(1, "A bad course !");
        ApplicationUser user1 = new ApplicationUser("mohamed", "maalej", "med",
                "123", new String[]{"admin", "user"});
        ApplicationUser user2 = new ApplicationUser("alex", "gabson", "alx",
                "123", new String[]{"user"});
        applicationUserRepository.save(user1);
        applicationUserRepository.save(user2);
        review.setReviewer(user1);
        review1.setReviewer(user2);
        review2.setReviewer(user2);
        course.addReview(review);
        course2.addReview(review1);
        course3.addReview(review2);

        courseRepository.save(course);
        courseRepository.save(course2);
        courseRepository.save(course3);*/
    }
}
