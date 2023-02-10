package es.rf.tienda.util;

import es.rf.tienda.dominio.Categoria;

/**
 * Clase mensaje para controlar los errores json
 * @author andrea.sanclemente
 *
 */

public class Mensaje {
	private int code;
	private String status;
	private Categoria data;
	
	public Mensaje(int code, String status, Categoria data) {
		this.code=code;
		this.status=status;
		this.data=data;
	}
	
	public Mensaje(int code, String status) {
		this.code = code;
		this.status = status;
	}
	
	public int getcode() {
		return code;
	}
	public void setcode(int code) {
		this.code = code;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}
	public Categoria getdata() {
		return data;
	}
	public void setdata(Categoria data) {
		this.data = data;
	}

	
	
}
