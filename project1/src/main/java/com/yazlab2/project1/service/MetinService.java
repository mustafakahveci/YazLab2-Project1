package com.yazlab2.project1.service;

import java.util.List;

import com.yazlab2.project1.entity.Metin;

public interface MetinService {
	public Metin saveMetin(Metin metin);
	public List<Metin> getAllMetin();
}
