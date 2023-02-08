package es.rf.tienda.controller;

import java.util.List;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.rf.tienda.dao.ICategoriaRepo;
import es.rf.tienda.dominio.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private ICategoriaRepo cDao;
	
	
	@GetMapping("/{id}")
	public String[] leerUno(@PathVariable("id") int id) {
		try {
			Categoria c = cDao.findById(id).get();
			return new String[] {"200",c.toString()};
		}catch (NoSuchElementException e) {
			return new String[] {"400", "No existe registro solicitado"};
		}
//		return cDao.findById(id).get();
	}
	//isvalid insert y isvalid update que se tendrian que hacer en un daoo service
	@PostMapping
	public String[] alta(@RequestBody Categoria c) {
		c.setId_categoria(0);
		if (c.isValid()) {
			cDao.save(c);
			return new String[] {"200", "Registro salvado"};
		}else {
			return new String[] {"500", "Registro no valido"};
		}
	}
	
	
	@PutMapping
	public String[] modificacion(@RequestBody Categoria c) {
		cDao.save(c);
		return new String[] {"200", "Modificacion correcta"};
	}
	
	@GetMapping
	public List<Categoria> leerTodos(){
		return cDao.findAll();
	}
	
	@DeleteMapping("/{id}")
	public String[] delete(@PathVariable("id") int id){
		try {
			cDao.deleteById(id);
			return new String[] {"200", "Registro eliminado"};
		}catch (NoSuchElementException e) {
			return new String[] {"400", "No existe registro solicitado"};
		}
	}	

}
