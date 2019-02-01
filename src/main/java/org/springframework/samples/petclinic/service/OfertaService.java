package org.springframework.samples.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.samples.petclinic.model.Oferta;

public interface OfertaService {

	Oferta findById(int id);

	List<Oferta> findAll();

	Oferta guardarOferta(Oferta oferta);

	void borrarOferta(int id);

}
