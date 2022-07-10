package javaodev.H5200004.repo;

import javax.persistence.Entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javaodev.H5200004.model.Kullanici;

@Repository
public interface KullaniciRepository extends CrudRepository<Kullanici,Long> {

}
