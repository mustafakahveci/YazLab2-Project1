package com.yazlab2.project1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yazlab2.project1.entity.Birlesik;
import com.yazlab2.project1.service.BirlesikService;

@RestController
@RequestMapping("/birlesik")
@CrossOrigin
public class BirlesikController {

	@Autowired
	private BirlesikService birlesikService;
	
	@PostMapping("/add")
	public String add(@RequestBody Birlesik birlesik) {
		birlesikService.saveBirlesik(birlesik);
		return "New birlesik is added";
	}
	
	@GetMapping("/getAll")
	public List<Birlesik> getAllBirlesik(){
		return birlesikService.getAllBirlesik();
	}
	
	
	
}
