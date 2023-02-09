package es.rf.tienda.dominio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Validator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "ALUMNO_ASS", name="USUARIOS")
public class Usuario {
	@Id
	private int id_usuario;						//id
	private String user_nombre;					//Nombre
	private String user_email;					//Correo electronico
	private String user_pass;					//Contraseña
	private int id_tipo;						//Tipo de usuario
	private String user_dni;					//DNI
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate user_fecAlta;				//FechaAlta
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate user_fecConfirmacion;		//FechaConfirmacion
	
	final static int CUMPLEMIN_5 = 5;
	final static int CUMPLEMAX_100 = 100;
	
	/**
	 * Constructor
	 */
	
	public Usuario() {
		super();
	}

	/**
	 * Getter de ID
	 * @return
	 */
	public int getId_usuario() {
		return id_usuario;
	}

	/**
	 * Setter de id
	 * @param id_usuario
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	/**
	 * Getter de nombre
	 * @return
	 */
	public String getUser_nombre() {
		return user_nombre;
	}

	/**
	 * Setter de nombre
	 * @param user_nombre
	 * @throws DomainException 
	 */
	public void setUser_nombre(String user_nombre) throws DomainException {
		if(Validator.cumpleLongitud(user_nombre, CUMPLEMIN_5, CUMPLEMAX_100)) {
			this.user_nombre = user_nombre;
		}else{
			throw new DomainException("El nombre de usuario ha de ser minimo 5 carácteres y máximo 100");
		}
	}

	/**
	 * Getter correo electronico
	 * @return
	 */
	public String getUser_email() {
		return user_email;
	}

	/**
	 * Setter correo electronico
	 * @param user_email
	 * @throws DomainException
	 */
	public void setUser_email(String user_email) throws DomainException {
		if(Validator.isEmailValido(user_email)) {
			this.user_email = user_email;
		}else {
            throw new DomainException("El email no es válido");
		}
	}

	/**
	 * Getter contraseña
	 * @return
	 */
	public String getUser_pass() {
		return user_pass;
	}

	/**
	 * Setter contraseña
	 * @param user_pass
	 * @throws DomainException
	 */
	public void setUser_pass(String user_pass) throws DomainException {
		if(Validator.esPasswordValida(user_pass)) {
			this.user_pass = user_pass;
		}else {
            throw new DomainException("La contraseña no es valida, como mínimo 1 número, 1 letra y 1 carácter especial");
		}
	}

	/**
	 * Getter tipo de usuario
	 * @return
	 */
	public int getId_tipo() {
		return id_tipo;
	}

	/**
	 * Setter de tipo de usuario
	 * @param id_tipo
	 */
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	/**
	 * Getter de dni
	 * @return
	 */
	public String getUser_dni() {
		return user_dni;
	}

	/**
	 * Setter de dni
	 * @param user_dni
	 * @throws DomainException
	 */
	public void setUser_dni(String user_dni) throws DomainException {
		if(Validator.cumpleDNI(user_dni)) {
			this.user_dni = user_dni;
		}else {
            throw new DomainException("El dni no es correcto");
		}
	}

	/**
	 * Get user fecha alta
	 * @return
	 */
	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}

	/**
	 * Setter usa fecha alta
	 * @param user_fecAlta
	 * @throws DomainException
	 */
	public void setUser_fecAlta(LocalDate user_fecAlta) throws DomainException {
		if(Validator.valDateMax(user_fecAlta, LocalDate.now())) {
			this.user_fecAlta = user_fecAlta;
		}else {
            throw new DomainException("la fecha no es correcta");
		}
	}

	/**
	 * Getter Fecha confirmación
	 * @return
	 */
	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}

	/**
	 * Setter fecha confirmación
	 * @param user_fecConfirmacion
	 * @throws DomainException
	 */
	public void setUser_fecConfirmacion(LocalDate user_fecConfirmacion) throws DomainException {
		if(Validator.valDateMax(user_fecConfirmacion, LocalDate.now())) {
			this.user_fecConfirmacion = user_fecConfirmacion;
		}else {
            throw new DomainException("La fecha no es correcta");
		}
	}
	
}
