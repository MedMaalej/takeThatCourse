package com.takeThatCourse.takeThatCourse.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(exported = false)
public interface ApplicationUserRepository extends CrudRepository<ApplicationUser,Long> {
   ApplicationUser  findByUserName(String userName);
}
