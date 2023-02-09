package es.rf.tienda.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rf.tienda.dao.IUsuarioRepo;
import es.rf.tienda.dominio.Usuario;

@Service
public class ServicioUsuario implements IServicioUsuario{
	@Autowired
	private IUsuarioRepo uDao;

	public boolean insert(Usuario t){
		uDao.save(t);
		return true;
	}

	public boolean update(Usuario t){
		uDao.save(t);
		return true;
	}

	@Override
	public boolean deleteById(int s) {
		uDao.deleteById(s);
		return true;
	}

	@Override
	public List<Usuario> listAll() {
		return uDao.findAll();
	}

	@Override
	public Usuario leerUno(int s) {
		try {
			Usuario c = uDao.findById(s).get();
			return c;
		} catch (NoSuchElementException e) {
			return new Usuario();
		}
	}
}
