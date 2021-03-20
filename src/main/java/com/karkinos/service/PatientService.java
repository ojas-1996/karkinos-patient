package com.karkinos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.karkinos.model.Patient;
import com.karkinos.repository.PatientRepository;

@Service
public class PatientService 
{
	@Autowired
	PatientRepository patientRepository;

	public List<Patient> getAllPatient() 
	{
		List<Patient> patients = new ArrayList<Patient>();
		patientRepository.findAll().forEach(patient -> patients.add(patient));
		return patients;
	}

	public Patient getPatientById(int id) 
	{
		Optional<Patient> optional = patientRepository.findById(id);
		Patient patient = null;
		if (optional.isPresent()) {
			patient = optional.get();
		} else {
			throw new RuntimeException(" Patient not found for id :: " + id);
		}
		return patient;
	}

	public void saveOrUpdate(Patient patient) 
	{
		patientRepository.save(patient);
	}

	public void delete(int id) 
	{
		patientRepository.deleteById(id);
	}

	public Page<Patient> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.patientRepository.findAll(pageable);
	}
}