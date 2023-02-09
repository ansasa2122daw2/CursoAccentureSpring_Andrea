package es.rf.tienda.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rf.tienda.dao.ICategoriaRepo;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;

/**
 * Servicio de DAO
 * @author andrea.sanclemente
 *
 */
@Service
public class ServicioCategoria implements IServicioCategoria{

	@Autowired
	private ICategoriaRepo cDao;

	public boolean insert(Categoria t) throws DAOException {
		if (t.isValidInsert()) {
			cDao.save(t);
			return true;
		}else {
			throw new DAOException("Error al insertar el valor, no puede ser null");
		}
	}
	
	public boolean update(Categoria t) throws DAOException {
		if (t.isValidUpdate()) {
			cDao.save(t);
			return true;
		}else {
			throw new DAOException("Error al insertar el valor, no puede ser null y id mayor que 0");
		}
	}

	@Override
	public boolean deleteById(int s) {
		cDao.deleteById(s);
		return true;
	}

	@Override
	public List<Categoria> listAll() {
		return cDao.findAll();
	}

	@Override
	public Categoria leerUno(int s) {
		try {
			Categoria c = cDao.findById(s).get();
			return c;
		}catch(NoSuchElementException e) {
			return new Categoria();
		}
	}

}
