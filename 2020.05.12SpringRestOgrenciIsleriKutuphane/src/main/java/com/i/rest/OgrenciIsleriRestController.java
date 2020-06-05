package com.i.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.i.domain.OgrenciIsleri;
import com.i.service.OgrenciIsleriService;

@RestController
@RequestMapping("/ogrenci-isleri")
public class OgrenciIsleriRestController {

	@Autowired
	private OgrenciIsleriService ogrenciIsleriService;
	
	


	@GetMapping("/{ogrNo}")
	public OgrenciIsleri getAktifOgr(@PathVariable int ogrNo) {
		return  ogrenciIsleriService.getOgrencifromOgrNo(ogrNo);
	}
	
	
}
