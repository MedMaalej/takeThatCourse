package com.takeThatCourse.takeThatCourse.model;


import com.takeThatCourse.takeThatCourse.core.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Course extends BaseEntity {


    private String title;
    private String url;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    List<Review> reviewList;

    protected Course() {
       super();
       reviewList= new ArrayList<>();
    }

    public Course(String title, String url) {
        this();
        this.title = title;
        this.url = url;
    }

    public void addReview(Review review) {
        review.setCourse(this);
        reviewList.add(review);
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
