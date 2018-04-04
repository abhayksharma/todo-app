/* This is repository interface which uses Spring Data JPA CrudRepository to provide the CRUD operations */
package com.todoapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends CrudRepository<Job,Integer>{

}
