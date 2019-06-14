package com.auditing.audit.repository;

import com.auditing.audit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository annotation. This tells Spring to bootstrap the repository
//        during a component scan.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();
    User findById(long id);


}
