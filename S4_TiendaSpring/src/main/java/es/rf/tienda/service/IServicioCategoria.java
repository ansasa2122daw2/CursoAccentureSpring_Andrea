package es.rf.tienda.service;

import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;

public interface IServicioCategoria{

	public boolean insert(Categoria t) throws DAOException;
	public boolean update(Categoria t) throws DAOException;
	public boolean deleteById(int s);
	public List<Categoria> listAll();
	public Categoria leerUno(int s);
	
}
