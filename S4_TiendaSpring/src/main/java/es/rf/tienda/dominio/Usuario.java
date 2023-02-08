package es.rf.tienda.dominio;

import java.time.LocalDate;
import java.util.List;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Validator;

public class Usuario {
	private int id_usuario;						//id
	private String user_nombre;					//Nombre
	private String user_email;					//Correo electronico
	private String user_pass;					//Contraseña
	private int id_tipo; //REVISAR				//Tipo de usuario
	private String user_dni;					//DNI
	private LocalDate user_fecAlta;				//FechaAlta
	private LocalDate user_fecConfirmacion;		//FechaConfirmacion
	private Direccion user_pago; //REVISAR		//Datos de pago
	private Direccion user_envio; //REVISAR		//Datos de envio
	
	/**
	 * Constructor
	 */
	
	public Usuario() {
		super();
	}

	/**
	 * getters y setters
	 */

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUser_nombre() {
		return user_nombre;
	}

	public void setUser_nombre(String user_nombre) {
		this.user_nombre = user_nombre;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) throws DomainException {
		if(Validator.isEmailValido(user_email)) {
			this.user_email = user_email;
		}else {
            throw new DomainException("El email no es válido");
		}
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) throws DomainException {
		if(Validator.esPasswordValida(user_pass)) {
			this.user_pass = user_pass;
		}else {
            throw new DomainException("La contraseña no es valida");
		}
	}

	public int getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getUser_dni() {
		return user_dni;
	}

	public void setUser_dni(String user_dni) throws DomainException {
		if(Validator.cumpleDNI(user_dni)) {
			this.user_dni = user_dni;
		}else {
            throw new DomainException("El dni no es correcto");
		}
	}

	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}

	public void setUser_fecAlta(LocalDate user_fecAlta) throws DomainException {
		if(Validator.valDateMax(user_fecAlta, LocalDate.now())) {
			this.user_fecAlta = user_fecAlta;
		}else {
            throw new DomainException("la fecha no es correcta");
		}
	}

	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}

	public void setUser_fecConfirmacion(LocalDate user_fecConfirmacion) throws DomainException {
		if(Validator.valDateMax(user_fecConfirmacion, LocalDate.now())) {
			this.user_fecConfirmacion = user_fecConfirmacion;
		}else {
            throw new DomainException("La fecha no es correcta");
		}
	}

	public Direccion getUser_pago() {
		return user_pago;
	}

	public void setUser_pago(Direccion user_pago) {
		this.user_pago = user_pago;
	}

	public Direccion getUser_envio() {
		return user_envio;
	}

	public void setUser_envio(Direccion user_envio) {
		this.user_envio = user_envio;
	}

	
	
	
	
	
}
