package com.i.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.i.domain.Kutuphane;
import com.i.domain.OgrenciIsleri;
import com.i.service.KutuphaneService;

@RestController
@RequestMapping("/kutuphane")
public class KutuphaneRestController {

	@Autowired
	private KutuphaneService kutuphaneService;
	
	
	@GetMapping("/")
	public List<Kutuphane> kutuphane(){
		
		return kutuphaneService.getKutuphane();
	}

	@GetMapping("/{indeks}")
	public OgrenciIsleri getOgr(@PathVariable int indeks) {
		OgrenciIsleri ogr=kutuphaneService.getOgrenci(indeks);
		
		if(ogr!=null) {
			return ogr;
		}else {
			return null;
		}
	}
	
}
