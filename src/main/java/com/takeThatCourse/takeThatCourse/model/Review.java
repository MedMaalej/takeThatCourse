package com.takeThatCourse.takeThatCourse.model;

import com.takeThatCourse.takeThatCourse.core.BaseEntity;

import javax.persistence.*;

@Entity
public class Review extends BaseEntity {

    private int rating;
    private String description;
    @ManyToOne
    private Course course;
    @ManyToOne
    private ApplicationUser reviewer;
    public Review() {
      super();
    }
    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public ApplicationUser getReviewer() {
        return reviewer;
    }

    public void setReviewer(ApplicationUser reviewer) {
        this.reviewer = reviewer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
