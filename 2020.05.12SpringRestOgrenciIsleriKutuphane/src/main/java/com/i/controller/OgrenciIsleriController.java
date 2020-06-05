package com.i.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.i.domain.OgrenciIsleri;
import com.i.service.OgrenciIsleriService;

@Controller
public class OgrenciIsleriController {

	@Autowired
	OgrenciIsleriService ogrenciIsleriService;
	
	final String serverUrl = "http://localhost:8081/SpringRestControllerKutuphane/kutuphane";
	 RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(path = "/ogrenciisleri")
	public String listOgrenciIsleri(Model model) {
		
		List<OgrenciIsleri> ogrIsList=ogrenciIsleriService.getOgrenciIsleri();
		
		model.addAttribute("ogrenciler", ogrIsList);
		
		return"ogrenciisleri-list";
	}
	
	@RequestMapping("/mezuniyet")
	public String mezuniyet(@RequestParam("ogrenciId") int id,Model model) {
		OgrenciIsleri ogrenci=ogrenciIsleriService.getOgrenci(id);
		model.addAttribute("ogr",ogrenci);
		return "ogrenciisleri-form";
	}
	
	@PostMapping("/mezunEt")
	public String mezunEt(@ModelAttribute("ogr") OgrenciIsleri ogrenci, Model model){
		OgrenciIsleri ogrGelen=ktphnKytSorgu(ogrenci.getId());
	if(ogrGelen!=null) {
			String uyari= ogrenci.getOgrenciNo()+" no'lu ogrenci "+ogrenci.getAd()+" "+ogrenci.getSoyad()+ 
					" aldigi kitaplari teslim etmesi gerekmektedir.";
			model.addAttribute("mesaj",uyari);
			List <OgrenciIsleri> ogrList=ogrenciIsleriService.getOgrenciIsleri();
			model.addAttribute("ogrenciler",ogrList);
			return "ogrenciisleri-list";
		}
		
		ogrenciIsleriService.saveOgrenci(ogrenci);
		return "redirect:/ogrenciisleri";
	}
	
	public OgrenciIsleri ktphnKytSorgu(int ogrId) {
		return restTemplate.getForObject(serverUrl+"/"+ogrId, OgrenciIsleri.class);
	}
	
}
