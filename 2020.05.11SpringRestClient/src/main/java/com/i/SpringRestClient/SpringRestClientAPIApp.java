package com.i.SpringRestClient;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.i.SpringRestClient.domain.Ogrenci;

public class SpringRestClientAPIApp {

	static final String serverUrl= "http://localhost:8081/SpringRestController/students/";
	
	static RestTemplate restTemplate= new RestTemplate();

			private static Ogrenci getOgrenci(int ogrenciId) {
				
				return restTemplate.getForObject(serverUrl+ ogrenciId,Ogrenci.class);
					
			}

			public static List<Ogrenci>getOgrenciler(){
			
				ResponseEntity<List<Ogrenci>> respEntity=
				//adrese git method cagir ve donen seyin tipi
				restTemplate.exchange(serverUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Ogrenci>>() {} );
				return respEntity.getBody();
				
			}

			private static void saveOgrenci(Ogrenci ogrenci){
				if(ogrenci.getId()==0) {
					restTemplate.postForEntity(serverUrl,ogrenci,Ogrenci.class);
				}
				else {
					restTemplate.put(serverUrl,ogrenci);
				}
			}
			
			
			private static void insertOgrenci(Ogrenci ogrenci) {
				
				restTemplate.postForEntity(serverUrl,ogrenci,Ogrenci.class);
				System.out.println(ogrenci.getId());
				
			}
			
			private static void updateOgrenci(Ogrenci ogrUpdating) {
				
				restTemplate.put(serverUrl,ogrUpdating);
					
				}
			
			
			private static void deleteOgrenci(int id) {
				restTemplate.delete(serverUrl+id);
				
			}
			
	public static void main(String[] args) {
		Ogrenci ogr=getOgrenci(2);
		System.out.println(ogr);
		/*System.out.println("*************");
		Ogrenci ogrInserting= new Ogrenci("zeynep","aydin",5321,null);
		insertOgrenci(ogrInserting);
		System.out.println(ogrInserting);*/
		
		/*System.out.println("*************");
		Ogrenci ogrUpdating= getOgrenci(11);
		System.out.println(ogrUpdating);
		
		ogrUpdating.setOgrenciNo(14);
		updateOgrenci(ogrUpdating);
		
		System.out.println(ogrUpdating);*/
		/*System.out.println("*************");
		Ogrenci ogrenci= getOgrenci(11);
		System.out.println(ogrenci);
		
		ogrenci.setOgrenciNo(15);
		saveOgrenci(ogrenci);
		
		System.out.println(ogrenci);*/
		
	/*	System.out.println("*************");
		Ogrenci ogrenci= getOgrenci(11);
		deleteOgrenci(ogrenci.getId());
		*/
		
		List<Ogrenci> ogrenciler= getOgrenciler();
		for (Ogrenci ogrenci : ogrenciler) {
			System.out.println(ogrenci);
			
		}
		
	}


			
}
