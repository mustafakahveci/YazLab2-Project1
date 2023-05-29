package com.yazlab2.project1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yazlab2.project1.entity.Birlesik;
import com.yazlab2.project1.repository.BirlesikRepository;

@Service
public class BirlesikServiceImpl implements BirlesikService {

	@Autowired
	private BirlesikRepository birlesikRepository;

	@Autowired
	private MetinServiceImpl metinServiceImpl;

	ArrayList<String> birlesik_string = new ArrayList<String>();
	ArrayList<String[]> ayrı_kelime_metinler = new ArrayList<String[]>();

	@Override
	public Birlesik saveBirlesik(Birlesik birlesik) {
		
		long startTime = System.nanoTime();

		for (int i = 0; i < metinServiceImpl.metinler.size(); i++) { // metinleri kelime kelime ayırıp array liste
																		// atadığımız döngü
			String str[] = metinServiceImpl.metinler.get(i).split(" ");
			ayrı_kelime_metinler.add(str);
		}

		for (int i = 0; i < ayrı_kelime_metinler.size(); i++) { // metinleri karşılaştırdığımız döngü

			for (int j = 0; j < ayrı_kelime_metinler.get(i).length; j++) {
				if (i == ayrı_kelime_metinler.size() - 1) { // son döngüyü ekliyoruzz direkt...
					birlesik_string.add(ayrı_kelime_metinler.get(i)[j]);
				} else if (ayrı_kelime_metinler.get(i)[j].equals(ayrı_kelime_metinler.get(i + 1)[0])) {
					break;
				} else {
					birlesik_string.add(ayrı_kelime_metinler.get(i)[j]);
				}
			}
		}
		
		birlesik.setText(birlesik_string.toString());
		
		long endTime = System.nanoTime(); 
		long estimatedTime = endTime - startTime;  // Geçen süre nanosaniye cinsinden elde edilir
		double seconds = (double)estimatedTime/1000000000; // saniyeye çevirmek için milyar'a bölüyoruz.
		
		birlesik.setSeconds(seconds);
		return birlesikRepository.save(birlesik);
	}

	@Override
	public List<Birlesik> getAllBirlesik() {
		return birlesikRepository.findAll();
	}

}
