package com.brunohfc.restapi205.demo.repository.auth;

import com.brunohfc.restapi205.demo.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("SELECT u FROM User u WHERE u.user_name =:userName ")
    User findByUsername(@Param("userName") String userName);
}
