package org.springframework.samples.petclinic.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.Oferta;

@Resource
public interface OfertaRepository extends JpaRepository<Oferta, Integer> {

	@Query("select o from Oferta o where o.fecha >= CURRENT_DATE")
	List<Oferta> findOfertasVigentes();

}
