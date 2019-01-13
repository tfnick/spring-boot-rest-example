package com.gr.springboot.rest.repository;

import com.gr.springboot.rest.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}