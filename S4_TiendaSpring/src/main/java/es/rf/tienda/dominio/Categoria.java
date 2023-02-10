package es.rf.tienda.dominio;

import es.rf.tienda.exception.DomainException;

import es.rf.tienda.util.Validator;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(schema = "ALUMNO_ASS", name="CATEGORIAS")
public class Categoria implements Modelo{
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	//@OneToMany(targetEntity = Producto.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private int id_categoria;			//identificador categoria
	
	@Column(nullable=false)
	private String cat_nombre;			//nombre de la categoria
	
	@Column(nullable = true, length = 200)
	private String cat_descripcion;		//descripcion de la categoria
	
	
	final static int CUMPLE_5 = 5;
	final static int CUMPLE_50 = 50;
	final static int CUMPLE_200 = 200;
	
	public Categoria(){}

	public Categoria(int id_categoria, String cat_nombre, String cat_descripcion) {
		super();
		this.id_categoria = id_categoria;
		this.cat_nombre = cat_nombre;
		this.cat_descripcion = cat_descripcion;
	}

	/**
	 * Getter para identificador de categoria
	 * @return Integer con el id de la categoria
	 */
	public int getId_categoria() {
		return id_categoria;
	}
	
	/**
	 * Setter para identificador de categoria
	 * 
	 */
	public void setId_categoria(int id_categoria) {
		if(isValidInsert() || isValidUpdate()) {
			this.id_categoria = id_categoria;
		}
	}
	
	/**
	 * Getter para el nombre de categoria
	 * @return cadena con el nombre de la categoria
	 */
	public String getCat_nombre() {
		return cat_nombre;
	}
	
	/**
	 * Setter para el nombre de categoria
	 * @throws DomainException 
	 * 
	 */
	public void setCat_nombre(String cat_nombre) throws DomainException {
		if(Validator.cumpleLongitud(cat_nombre, CUMPLE_5, CUMPLE_50) && isValidInsert() || isValidUpdate()) {
			this.cat_nombre = cat_nombre;
		}else {
            throw new DomainException("Error no cumple la longitud mínima de 5 y máxima de 50");
		}
		
	}
	
	/**
	 * Getter para la descripcion de categoria
	 * @return cadena con la descripcion de la categoria
	 */
	public String getCat_descripcion() {
		return cat_descripcion;
	}
	
	/**
	 * setter para la descripcion de categoria
	 * @throws DomainException 
	 * 
	 */
	public void setCat_descripcion(String cat_descripcion) throws DomainException {
		this.cat_descripcion = cat_descripcion==null? null: StringUtils.truncate(cat_descripcion, CUMPLE_200);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cat_descripcion == null) ? 0 : cat_descripcion.hashCode());
		result = prime * result + ((cat_nombre == null) ? 0 : cat_nombre.hashCode());
		result = prime * result + id_categoria;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (cat_descripcion == null) {
			if (other.cat_descripcion != null)
				return false;
		} else if (!cat_descripcion.equals(other.cat_descripcion))
			return false;
		if (cat_nombre == null) {
			if (other.cat_nombre != null)
				return false;
		} else if (!cat_nombre.equals(other.cat_nombre))
			return false;
		if (id_categoria != other.id_categoria)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", cat_nombre=" + cat_nombre + ", cat_descripcion="
				+ cat_descripcion + "]";
	}

	@Override
	public boolean isValidInsert() {
		boolean result = !Validator.isVacio(cat_nombre);
		return result;
	}

	@Override
	public boolean isValidUpdate() {
		boolean result = !Validator.isVacio(cat_nombre) &&
				id_categoria > 0;
		return result;
	}
	
	
}
