package es.rf.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rf.tienda.dao.ICategoriaRepo;
import es.rf.tienda.dao.IProductoRepo;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Producto;

@Service
public class ServicioProducto implements IServicioProducto {
	

	@Autowired
	private IProductoRepo pDao;

	@Override
	public void insert(Producto t) {
		pDao.save(t);
	}

	@Override
	public void update(Producto t) {
		pDao.save(t);
	}

	@Override
	public boolean deleteById(String s) {
		pDao.deleteById(s);
		return true;
	}

	@Override
	public List<Producto> listAll() {
		return pDao.findAll();
	}

	@Override
	public Producto leerUno(String s) {
		Producto c = pDao.findById(s).get();
		return c;

	}

}
