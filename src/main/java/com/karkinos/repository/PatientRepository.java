package com.karkinos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.karkinos.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer>{

	Page<Patient> findAll(Pageable pageable);
	
}
