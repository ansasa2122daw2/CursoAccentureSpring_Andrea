package es.rf.tienda.service;

import java.util.List;

import es.rf.tienda.dominio.Usuario;

public interface IServicioUsuario {
	public boolean insert(Usuario t);
	public boolean update(Usuario t);
	public boolean deleteById(int s);
	public List<Usuario> listAll();
	public Usuario leerUno(int s);
}
