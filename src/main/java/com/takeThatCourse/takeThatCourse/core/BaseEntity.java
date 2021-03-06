package com.takeThatCourse.takeThatCourse.core;


import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;


    public BaseEntity() {
        id = null;
    }

    public Long getId() {
        return id;
    }
}
