package es.rf.tienda.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.dao.ICategoriaRepo;
import es.rf.tienda.dao.IProductoRepo;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Producto;
import es.rf.tienda.exception.ControllerException;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.service.IServicioCategoria;
import es.rf.tienda.service.IServicioProducto;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.Mensaje;

@RestController
@CrossOrigin
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IServicioProducto cDao;

	@Autowired
	private IProductoRepo sDao;

	/**
	 * Método getMapping que coje el ID y lee una categoria Excepciones
	 * NumberFormatException y de NumberFormatException al pasar un String llamando
	 * a la clase ErrorMessages para ver cual Ponemos String id para luego poder
	 * hacer el parseInt y detectar esa excepcion
	 * 
	 * @param id
	 * @return
	 */
	/*
	 * @GetMapping("/{id}") public Mensaje leerUno(@PathVariable("id") String id) {
	 * try { int idS = Integer.parseInt(id); try { Categoria c = cDao.leerUno(idS);
	 * if (c == null) { return new Mensaje(400, ErrorMessages.PROERR_004); } else {
	 * return new Mensaje(200, "OK", c); } } catch (NoSuchElementException e) {
	 * return new Mensaje(400, ErrorMessages.PROERR_004); } } catch
	 * (NumberFormatException e) { return new Mensaje(400,
	 * ErrorMessages.PROERR_001); }
	 * 
	 * }
	 */

	@GetMapping("/{id}")
	public ResponseEntity leerUno(@PathVariable("id") String id) throws ControllerException {
		String mensaje = "";
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			try {
				Producto c = cDao.leerUno(id);
				if (c == null) {
					mensaje = "No existen datos";
				} else {
					map.put("status", 1);
					map.put("data", c);
					return new ResponseEntity<>(map, HttpStatus.OK);
				}
			} catch (NoSuchElementException e) {
				mensaje = "ID no encontrado";
			}
		} catch (NumberFormatException e) {
			mensaje = "ID formato erroneo";
		}
		throw new ControllerException(mensaje);

	}

	/**
	 * Método alta controlando los errores
	 * 
	 * @param c
	 * @return
	 * @throws DAOException
	 */
	@PostMapping
	public Mensaje alta(@RequestBody Producto c) {
		try {
			c.setId_categoria(0);
			cDao.insert(c);
			return new Mensaje(200, "Registro salvado");
		} catch (DomainException d) {
			return new Mensaje(400, d.getMessage());
		} catch (DAOException e) {
			return new Mensaje(400, e.getMessage());
		}
	}

	/**
	 * Método Modificacion
	 * 
	 * @param c
	 * @return
	 * @throws DAOException
	 */
	@PutMapping
	public Mensaje modificacion(@RequestBody Producto c) {
		try {
			cDao.update(c);
			return new Mensaje(200, "Registro modificado");
		} catch (DomainException d) {
			return new Mensaje(400, d.getMessage());
		} catch (DAOException e) {
			return new Mensaje(400, e.getMessage());
		}
	}

	/**
	 * Método listar todos
	 * 
	 * @return
	 */
	@GetMapping
	public List<Producto> leerTodos() {
		return cDao.listAll();
	}

	/**
	 * Método Delete similar al de listar uno
	 * 
	 * @param id
	 * @return
	 */
	/*
	 * @DeleteMapping("/{id}") public Mensaje delete(@PathVariable("id") String id)
	 * { try { int idS = Integer.parseInt(id); if (sDao.existsById(idS)) {
	 * cDao.deleteById(idS); return new Mensaje(200, "Registro eliminado"); } else {
	 * return new Mensaje(400, ErrorMessages.PROERR_004); } } catch
	 * (NumberFormatException e) { return new Mensaje(400,
	 * ErrorMessages.PROERR_001); } }
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) throws ControllerException {
		String mensaje = "";
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			if (sDao.existsById(id)) {
				cDao.deleteById(id);
				return new ResponseEntity<>(map, HttpStatus.OK);
			} else {
				mensaje = "No existe ese ID que deseas eliminar";
			}
		} catch (NumberFormatException e) {
			mensaje = "Formato ID erroneo";
		}
		throw new ControllerException(mensaje);
	}

}
