package es.rf.tienda.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.dominio.Direccion;
import es.rf.tienda.service.IServicioDireccion;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

	@Autowired
	private IServicioDireccion dDao;

	@GetMapping("/{id}")
	public String[] leerUno(@PathVariable("id") String id) {
		try {
			Direccion c = dDao.leerUno(id);
			return new String[] { "200", c.toString() };
		} catch (NoSuchElementException e) {
			return new String[] { "400", "No existe registro solicitado" };
		}
	}

	@PostMapping
	public String[] alta(@RequestBody Direccion c) {
		dDao.insert(c);
		return new String[] { "200", "Registro salvado" };
	}

	@PutMapping
	public String[] modificacion(@RequestBody Direccion c) {
		dDao.update(c);
		return new String[] { "200", "Registro salvado" };
	}

	@GetMapping
	public List<Direccion> leerTodos() {
		return dDao.listAll();
	}

	@DeleteMapping("/{id}")
	public String[] delete(@PathVariable("id") String id) {
		try {
			dDao.deleteById(id);
			return new String[] { "200", "Registro eliminado" };
		} catch (NoSuchElementException e) {
			return new String[] { "400", "No existe registro solicitado" };
		}
	}

}
