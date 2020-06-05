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

import com.i.domain.Ogrenci;
import com.i.service.OgrenciService;

@RestController
@RequestMapping("/students")
public class OgrenciRestController {

	@Autowired
	private OgrenciService ogrenciService;
	
	@GetMapping("/")
	public List <Ogrenci> ogrenciler(){
		return ogrenciService.getOgrenciler();
	}
	
	@GetMapping("/{ogrId}")
	public Ogrenci getOgrenci(@PathVariable int ogrId){
		return ogrenciService.getOgrenci(ogrId);
	}
	
	@PostMapping("/")
	public Ogrenci addOgrenci(@RequestBody Ogrenci ogrenci) {
		//db e gonderme
		ogrenciService.addOgrenci(ogrenci);
		return ogrenci;
		
	}
	
	@PutMapping("/")
	public Ogrenci updateOgrenci(@RequestBody Ogrenci ogrenci) {
		//db e gonderme
		ogrenciService.updateOgrenci(ogrenci);
		return ogrenci;
		
	}
	
	@DeleteMapping("/{ogrId}")
	public String deleteOgrenci(@PathVariable int ogrId) {
		
		int sonuc=ogrenciService.deleteOgrenci(ogrId);
		if(sonuc>0)
			return sonuc+"adet kayit silindi";
		else 
			return ogrId+"id'li bir kayit bulunamadi";
	}
	
	
}
