package org.springframework.samples.petclinic.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Oferta;
import org.springframework.samples.petclinic.service.OfertaServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class OfertaController {

	@Autowired
	private OfertaServiceImpl ofertaService;

	@RequestMapping(value = "/ofertas", method = RequestMethod.GET)
	public List<Oferta> findAll() {
		return this.ofertaService.findAll();
	}

	@RequestMapping(value = "/ofertas/{id}", method = RequestMethod.GET)
	public Oferta findById(@PathVariable("id") Integer id) {
		Oferta o = this.ofertaService.findById(id);
		return o;
	}

	@RequestMapping(value = "/ofertas", method = RequestMethod.POST)
	public ResponseEntity<Oferta> guardarOferta(@RequestBody Oferta o) {
		if (o != null)
			return ResponseEntity.status(HttpStatus.OK).body(this.ofertaService.guardarOferta(o));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

	}
	
	@RequestMapping(value="/ofertas/{id}", method=RequestMethod.DELETE) 
	public ResponseEntity<Oferta> borrarOferta(@PathVariable("id") Integer id) {
		Oferta o = this.ofertaService.findById(id);
		if(o != null) {
			this.ofertaService.borrarOferta(o.getId());
			return ResponseEntity.status(HttpStatus.OK).body(o);			
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);	
	}
	
	@RequestMapping(value = "/ofertas/listOfertasVigentes", method = RequestMethod.GET)
	public List<Oferta> listOfertasVigentes() {
		return this.ofertaService.findOfertasVigentes();
	}

}