package es.rf.tienda.service;

import java.util.List;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rf.tienda.dao.IDireccionRepo;
import es.rf.tienda.dominio.Direccion;

@Service
public class ServicioDireccion implements IServicioDireccion{

	@Autowired
	private IDireccionRepo dDao;

	public boolean insert(Direccion t){
		dDao.save(t);
		return true;
	}

	public boolean update(Direccion t){
		dDao.save(t);
		return true;
	}

	@Override
	public boolean deleteById(String s) {
		dDao.deleteById(s);
		return true;
	}

	@Override
	public List<Direccion> listAll() {
		return dDao.findAll();
	}

	@Override
	public Direccion leerUno(String s) {
		try {
			Direccion c = dDao.findById(s).get();
			return c;
		} catch (NoSuchElementException e) {
			return new Direccion();
		}
	}
}
