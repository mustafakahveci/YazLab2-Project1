package com.yazlab2.project1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yazlab2.project1.entity.Metin;
import com.yazlab2.project1.repository.MetinRepository;

@Service
public class MetinServiceImpl implements MetinService{

	@Autowired
	private MetinRepository metinRepository;
	
	public ArrayList<String> metinler = new ArrayList<String>();
	
	@Override
	public Metin saveMetin(Metin metin) {
		metinler.add(metin.getText());
		return metinRepository.save(metin);
	}

	@Override
	public List<Metin> getAllMetin() {
		return metinRepository.findAll();
	} 
	
	public ArrayList<String> metinleriDon(ArrayList<String> metinler){
		return metinler;
		
	}
}
