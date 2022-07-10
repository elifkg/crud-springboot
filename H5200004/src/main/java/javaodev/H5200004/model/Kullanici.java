package javaodev.H5200004.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
public class Kullanici {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String ad;
private String soyad;
private String	dogumtarihi;
private String telefon;


}
