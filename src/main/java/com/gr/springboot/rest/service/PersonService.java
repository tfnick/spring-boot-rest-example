package com.gr.springboot.rest.service;

import com.gr.springboot.rest.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gr.springboot.rest.repository.PersonRepository;

@Service
@Transactional
public class PersonService {

	@Autowired 
	private PersonRepository repository;

	@Transactional(readOnly = true)
	public Page<Person> findAll(Pageable pageable) {
		
		return repository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Person findOne(Long id) {
		
		return repository.getOne(id);
	}
	
	public Person save(Person person) {
		
		return repository.saveAndFlush(person);
	}
}
