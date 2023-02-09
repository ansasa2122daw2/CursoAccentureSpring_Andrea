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

import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.service.IServicioUsuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IServicioUsuario uDao;

	@GetMapping("/{id}")
	public String[] leerUno(@PathVariable("id") int id) {
		try {
			Usuario c = uDao.leerUno(id);
			return new String[] { "200", c.toString() };
		} catch (NoSuchElementException e) {
			return new String[] { "400", "No existe registro solicitado" };
		}
	}

	@PostMapping
	public String[] alta(@RequestBody Usuario c) {
		uDao.insert(c);
		return new String[] { "200", "Registro salvado" };
	}

	@PutMapping
	public String[] modificacion(@RequestBody Usuario c) {
		uDao.update(c);
		return new String[] { "200", "Registro salvado" };
	}

	@GetMapping
	public List<Usuario> leerTodos() {
		return uDao.listAll();
	}

	@DeleteMapping("/{id}")
	public String[] delete(@PathVariable("id") int id) {
		try {
			uDao.deleteById(id);
			return new String[] { "200", "Registro eliminado" };
		} catch (NoSuchElementException e) {
			return new String[] { "400", "No existe registro solicitado" };
		}
	}
}
