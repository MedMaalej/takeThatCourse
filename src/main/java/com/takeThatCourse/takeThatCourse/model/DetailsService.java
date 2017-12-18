package com.takeThatCourse.takeThatCourse.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DetailsService implements UserDetailsService{
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      ApplicationUser user= applicationUserRepository.findByUserName(username) ;
      if(user == null) {
          throw new UsernameNotFoundException(username+" was not found !");
      }
      return new org.springframework.security.core.userdetails.User(
              user.getFirstName(),
              user.getPassword(),
              AuthorityUtils.createAuthorityList(user.getRoles())

      );
    }
}