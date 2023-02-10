package es.rf.tienda.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rf.tienda.dao.ICategoriaRepo;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;

/**
 * Servicio de DAO
 * 
 * @author andrea.sanclemente
 *
 */
@Service
public class ServicioCategoria implements IServicioCategoria {

	@Autowired
	private ICategoriaRepo cDao;

	@Override
	public void insert(Categoria t){
		if(t.isValidInsert()) {
			cDao.save(t);
		}
	}

	@Override
	public boolean update(Categoria t) {
		cDao.save(t);
		return true;
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
		Categoria c = cDao.findById(s).get();
		return c;

	}

}
