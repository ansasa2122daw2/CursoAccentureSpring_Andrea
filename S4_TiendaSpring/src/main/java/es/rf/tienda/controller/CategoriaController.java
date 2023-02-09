package es.rf.tienda.controller;

import java.util.List;


import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import es.rf.tienda.dao.ICategoriaRepo;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.service.IServicioCategoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private IServicioCategoria cDao;
	
	
	@GetMapping("/{id}")
	public String[] leerUno(@PathVariable("id") int id) {
		try {
			Categoria c = cDao.leerUno(id);
			return new String[] {"200",c.toString()};
		}catch (NoSuchElementException e) {
			return new String[] {"400", "No existe registro solicitado"};
		}
	}

	@PostMapping
	public String[] alta(@RequestBody Categoria c) throws DAOException {
		c.setId_categoria(0);
		if (c.isValidInsert()) {
			cDao.insert(c);
			return new String[] {"200", "Registro salvado"};
		}else {
			return new String[] {"500", "Registro no valido"};
		}
	}
	
	
	@PutMapping
	public String[] modificacion(@RequestBody Categoria c) throws DAOException {
		if (c.isValidUpdate()) {
			cDao.update(c);
			return new String[] {"200", "Registro salvado"};
		}else {
			return new String[] {"500", "Registro no valido"};
		}
	}
	
	@GetMapping
	public List<Categoria> leerTodos(){
		return cDao.listAll();
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
