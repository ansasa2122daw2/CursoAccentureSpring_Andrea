package es.rf.tienda.dominio;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Validator;

/**
 * Nombre: Direccion
 * Descipcion: Clase Direccion
 * @author andrea.sanclemente
 *
 */

public class Direccion {
	private String dir_nombre;		//Nombre
	private String dir_direccion;	//Direccion
	private String dir_poblacion;	//Poblacion
	private String cPostal;			//Codigo postal
	private String dir_provincia;	//Provincia
	private String dir_pais;		//Pais
	private String dir_correoE;		//Correo electronico
	
	/**
	 * Constructor
	 */
	
	public Direccion() {
		super();
	}

	/**
	 * Getters y setters
	 * @return
	 */
	
	public String getDir_nombre() {
		return dir_nombre;
	}

	public void setDir_nombre(String dir_nombre){
		this.dir_nombre = dir_nombre;
		
	}

	public String getDir_direccion() {
		return dir_direccion;
	}

	public void setDir_direccion(String dir_direccion) {
		this.dir_direccion = dir_direccion;
		
	}

	public String getDir_poblacion() {
		return dir_poblacion;
	}

	public void setDir_poblacion(String dir_poblacion){
		this.dir_poblacion = dir_poblacion;
		
	}

	public String getcPostal() {
		return cPostal;
	}

	public void setcPostal(String cPostal) {
		this.cPostal = cPostal;
		
	}

	public String getDir_provincia() {
		return dir_provincia;
	}

	public void setDir_provincia(String dir_provincia){
		this.dir_provincia = dir_provincia;
		
	}

	public String getDir_pais() {
		return dir_pais;
	}

	public void setDir_pais(String dir_pais){
		this.dir_pais = dir_pais;
		
	}

	public String getDir_correoE() {
		return dir_correoE;
	}

	public void setDir_correoE(String dir_correoE){
		this.dir_correoE = dir_correoE;
		
	}

	@Override
	public String toString() {
		return "Direccion [dir_nombre=" + dir_nombre + ", dir_direccion=" + dir_direccion + ", dir_poblacion="
				+ dir_poblacion + ", cPostal=" + cPostal + ", dir_provincia=" + dir_provincia + ", dir_pais=" + dir_pais
				+ ", dir_correoE=" + dir_correoE + "]";
	}	
		
}
