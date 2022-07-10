package javaodev.H5200004.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javaodev.H5200004.model.Kullanici;
import javaodev.H5200004.model.KullaniciInput;
import javaodev.H5200004.model.KullaniciObject;
import javaodev.H5200004.repo.KullaniciRepository;

@RestController
public class KullaniciController {

	@Autowired
	KullaniciRepository kRepository;
	
	@PostMapping("/KullaniciOlustur")
	public KullaniciObject kullaniciOlustur(@RequestBody KullaniciObject kullaniciObject) {
		Kullanici kullanici = new Kullanici();
		kullanici.setAd(kullaniciObject.getAd());
		kullanici.setDogumtarihi(kullaniciObject.getDogumtarihi());
		kullanici.setSoyad(kullaniciObject.getSoyad());
		kullanici.setTelefon(kullaniciObject.getTelefon());
		kRepository.save(kullanici);
		return  kullaniciObject;
	}
	@GetMapping("/KullaniciGetir/{id}")
    public KullaniciObject kullniciGetir(long id) {
		Kullanici kullanici = kRepository.findById(id).get();
		KullaniciObject kullaniciObject = new KullaniciObject();
		kullaniciObject.setAd(kullanici.getAd());
		kullaniciObject.setSoyad(kullanici.getSoyad());
		kullaniciObject.setDogumtarihi(kullanici.getDogumtarihi());
		kullaniciObject.setTelefon(kullanici.getTelefon());
		return kullaniciObject;		
			
	}
	@GetMapping("/kullanicilar")
    public ArrayList<Kullanici> kisileriListele(){
		ArrayList<Kullanici> tumKisiler =(ArrayList<Kullanici>) kRepository.findAll();
		System.out.println("kişiler servisi çğrıldı." +  tumKisiler.size() + new Date());
		return tumKisiler;
	}
	
	
	 @PostMapping("/kullaniciGuncelle")
	 public String kullniciGuncelle(@RequestBody KullaniciInput kullaniciInput) {
			Kullanici kullanici = new Kullanici();
			
			kullanici.setId(kullaniciInput.getId());
			kullanici.setAd(kullaniciInput.getAd());
			kullanici.setSoyad(kullaniciInput.getSoyad());
			kullanici.setDogumtarihi(kullaniciInput.getDogumtarihi());
			kullanici.setTelefon(kullaniciInput.getTelefon());
			kRepository.save(kullanici);
			return "Kullanici güncellendi" + kullaniciInput;
		 }
	 
	 
	 
	 @DeleteMapping("/KullaniciSil")
      public String kullniciSil(long id) {
		 kRepository.deleteById(id);
       return id +  " id'li Kullanici silindi";

	 }
	
}


	
	

