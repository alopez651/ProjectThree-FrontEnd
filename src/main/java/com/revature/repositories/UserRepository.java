package com.revature.repositories;

import com.revature.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);
    //    List<User> findByFirstNameAndLastNameAndEmail(String firstname, String lastname, String email);
    @Query( value = " SELECT * from users where first_name =?1 or last_name =?1 or email=?1 ;", nativeQuery = true)
    List<User> findByString(String string);

    List<User> findByFirstName(String firstname);


    List<User> findByLastName(String lastname);


    List<User> findByEmail(String email);
}