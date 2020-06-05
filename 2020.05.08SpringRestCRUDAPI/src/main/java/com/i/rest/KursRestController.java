package com.i.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.i.domain.Kurs;
import com.i.service.KursService;

@RestController
@RequestMapping("/course")
public class KursRestController {

	@Autowired
	private KursService kursService;
	
	@GetMapping("/")
	public List <Kurs>kurslar(){
	return kursService.getKurslar();
		
	}
	
	@GetMapping("/{kursId}")
	public Kurs getKurs(@PathVariable int kursId) {
		
		return kursService.getKurs(kursId);
	}
	
	@PostMapping("/")
	public Kurs addKurs(@RequestBody Kurs kurs) {
		kursService.addKurs(kurs);
		return kurs;
	}
	
	@PutMapping("/")
	public Kurs updateKurs(@RequestBody Kurs kurs) {
		kursService.updateKurs(kurs);
		return kurs;
	}
	@DeleteMapping("/{kursid}")	
	public String deleteKurs(@PathVariable int kursid) {
		int sonuc=kursService.deleteKurs(kursid);
		if(sonuc>0)
			return sonuc+ "kurs silindi";
		else
			return kursid+ "böyle bir kurs kaydi yok.";
		
	}
	
}
