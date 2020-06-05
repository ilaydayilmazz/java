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

import com.i.domain.Kutuphane;
import com.i.domain.OgrenciIsleri;
import com.i.service.KutuphaneService;

@Controller

public class KutuphaneController {

	@Autowired
	KutuphaneService kutuphaneService;
	
	 final String serverUrl = "http://localhost:8081/SpringRestController/ogrenci-isleri";
	 RestTemplate restTemplate = new RestTemplate();
	
	
	@RequestMapping(path="/kutuphaneisleri")
	public String listKutuphane(Model model) {
		List <Kutuphane> kutuphaneList= kutuphaneService.getKutuphane();
		model.addAttribute("kitaplar", kutuphaneList);
		return "kutuphane-list";
		
	}
	@RequestMapping("/oduncAl")
	public String oduncAl(@RequestParam ("kitapId") int id, Model model) {
		Kutuphane kitap = kutuphaneService.getKitap(id);
		model.addAttribute("kitap",kitap);
		return "kutuphane-form";
	}
	
	@PostMapping("/kitapteslim")
	public String kitapteslim(@ModelAttribute("kitap") Kutuphane ktp, Model model) {
		OgrenciIsleri ogr = ogrAktfSorgu(ktp.getOgrenciIsleri().getOgrenciNo());
		if (ogr== null)
		{
			String uyari= ktp.getOgrenciIsleri().getOgrenciNo()+" no'lu ogrenci bulunamamistir.";
			model.addAttribute("mesaj",uyari);
			List<Kutuphane> kitapList= kutuphaneService.getKutuphane();
			model.addAttribute("kitaplar",kitapList);
			return "kutuphane-list";
		}
		
		ktp.setOgrenciIsleri(ogr);
		kutuphaneService.saveKitap(ktp);
		return "redirect:/kutuphaneisleri";
		
	}
	@RequestMapping("/ogrencibilgileri")	
	public String ogrBilgileri(@RequestParam("ogrNo")int ogrno,Model model) {
		OgrenciIsleri ogrnc=ogrAktfSorgu(ogrno);
		model.addAttribute("ogr", ogrnc);
		return "OgrenciBilgileri";
	}
	
	//Rest Metotlari
		public OgrenciIsleri ogrAktfSorgu(int ogrNo) {
			return restTemplate.getForObject(serverUrl+"/"+ogrNo, OgrenciIsleri.class);

		}
	
	
}
