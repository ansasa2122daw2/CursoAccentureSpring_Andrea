package es.rf.tienda.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.hibernate.sql.results.DomainResultCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.rf.tienda.dao.ICategoriaRepo;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.ControllerException;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.exception.ErrorRestResponse;
import es.rf.tienda.exception.RestRespondeEntityExceptionHandler;
import es.rf.tienda.service.IServicioCategoria;
import es.rf.tienda.service.ServicioCategoria;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.Mensaje;

/**
 * Clase Categoria controller
 * 
 * @author andrea.sanclemente
 *
 */
/**
 * GET Devolver ResponseEntity siempre respondes con eso
 * tener un status
 * metodo que devuleva responseentity
 * @author andrea.sanclemente
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private IServicioCategoria cDao;

	@Autowired
	private ICategoriaRepo sDao;

	/**
	 * Método getMapping que coje el ID y lee una categoria Excepciones
	 * NumberFormatException y de NumberFormatException al pasar un String llamando
	 * a la clase ErrorMessages para ver cual Ponemos String id para luego poder
	 * hacer el parseInt y detectar esa excepcion
	 * 
	 * @param id
	 * @return
	 */
	/*@GetMapping("/{id}")
	public Mensaje leerUno(@PathVariable("id") String id) {
		try {
			int idS = Integer.parseInt(id);
			try {
				Categoria c = cDao.leerUno(idS);
				if (c == null) {
					return new Mensaje(400, ErrorMessages.PROERR_004);
				} else {
					return new Mensaje(200, "OK", c);
				}
			} catch (NoSuchElementException e) {
				return new Mensaje(400, ErrorMessages.PROERR_004);
			}
		} catch (NumberFormatException e) {
			return new Mensaje(400, ErrorMessages.PROERR_001);
		}

	}*/
	
	@GetMapping("/{id}")
	public ResponseEntity leerUno(@PathVariable("id") String id) throws ControllerException{
		String mensaje="";
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		try {
			int idS = Integer.parseInt(id);
			try {
				Categoria c = cDao.leerUno(idS);
				if (c == null) {
					mensaje = "No existen datos";
				} else {
					map.put("status", 1);
					map.put("data", c);
					return new ResponseEntity<>(map, HttpStatus.OK);
				}
			} catch (NoSuchElementException e) {
				mensaje= "ID no encontrado";
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
	public Mensaje alta(@RequestBody Categoria c){
		try {
			c.setId_categoria(0);
			if (c.isValidInsert()) {
				cDao.insert(c);
				return new Mensaje(200, "Registro salvado");
			} else {
				return new Mensaje(400, "Registro no válido, " + ErrorMessages.PROERR_002);
			}
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
	public Mensaje modificacion(@RequestBody Categoria c) {
		try {
			if(c.isValidUpdate()) {
				cDao.update(c);
				return new Mensaje(200, "Registro modificado");
			}else {
				return new Mensaje(400, "Registro no válido, " + ErrorMessages.PROERR_004);
			}
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
	public List<Categoria> leerTodos() {
		return cDao.listAll();
	}

	/**
	 * Método Delete similar al de listar uno
	 * 
	 * @param id
	 * @return
	 */
	/*@DeleteMapping("/{id}")
	public Mensaje delete(@PathVariable("id") String id) {
		try {
			int idS = Integer.parseInt(id);
			if (sDao.existsById(idS)) {
				cDao.deleteById(idS);
				return new Mensaje(200, "Registro eliminado");
			} else {
				return new Mensaje(400, ErrorMessages.PROERR_004);
			}
		} catch (NumberFormatException e) {
			return new Mensaje(400, ErrorMessages.PROERR_001);
		}
	}*/
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") String id) throws ControllerException{
		String mensaje="";
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		try {
			int idS = Integer.parseInt(id);
			if (sDao.existsById(idS)) {
				cDao.deleteById(idS);
				return new ResponseEntity<>(map, HttpStatus.OK);
			} else {
				mensaje = "No existe ese ID que deseas eliminar";
			}
		} catch (NumberFormatException e) {
			mensaje= "Formato ID erroneo";
		}
		throw new ControllerException(mensaje);
	}

}
