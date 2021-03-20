package com.karkinos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karkinos.model.Patient;
import com.karkinos.service.PatientService;

@Controller
public class PatientController 
{
	@Autowired
	PatientService patientService;

	// display list of patients
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "fullName", "asc", model);		
	}

	@GetMapping("/showNewPatientForm")
	public String showNewPatientForm(Model model) {
		// create model attribute to bind form data
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return "add-patient";
	}

	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient patient) {
		// save patient to database
		patientService.saveOrUpdate(patient);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

		// get patient from the service
		Patient patient = patientService.getPatientById(id);

		// set patient as a model attribute
		model.addAttribute("patient", patient);
		return "update-patient";
	}

	@GetMapping("/deletePatient/{id}")
	public String deletePatient(@PathVariable (value = "id") int id) {

		// call delete patient method 
		this.patientService.delete(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;

		Page<Patient> page = patientService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Patient> listPatients = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listPatients", listPatients);
		return "index";
	}

}
