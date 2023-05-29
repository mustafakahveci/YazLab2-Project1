package com.yazlab2.project1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yazlab2.project1.entity.Metin;
import com.yazlab2.project1.service.MetinService;

@RestController
@RequestMapping("/metin")
@CrossOrigin
public class MetinController {
	
	@Autowired
	private MetinService metinService;

	@PostMapping("/add")
	public String add(@RequestBody Metin metin) {
		metinService.saveMetin(metin);
		return "New metin is added";
	}
	
	@GetMapping("/getAll")
	public List<Metin> getAllMetin(){
		return metinService.getAllMetin();
	}
	
	
	
}
