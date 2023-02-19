package es.rf.tienda.dominio;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Validator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Nombre: Producto
 * Descipcion: Clase Producto
 * @author andrea.sanclemente
 *
 */
@Entity
@Table(schema = "ALUMNO_ASS", name="PRODUCTOS")
public class Producto {
	@Id
	private String id_producto;				//código del producto

	private String pro_descripcion;			//descripcion corta
	private String pro_desLarga;			//explicacion
	private double pro_precio;				//precio
	private int pro_stock;					//stock
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate pro_fecRepos;			//fecha prevista reposicion
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate pro_fecActi;			//fecha activacion
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate pro_fecDesacti;		//fecha desactivacion
	private String pro_uniVenta;			//unidad de venta
	private double pro_cantXUniVenta;		//cantidad de unidades ultimas
	private String pro_uniUltNivel;			//unidad ultima
	
	private int id_pais;					//Pais de origen
	private String pro_usoRecomendado;		//Uso recomendado
	@ManyToOne(targetEntity = Categoria.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria") 
	private int id_categoria;				//Categoria
	private int pro_stkReservado;			//Stock reservado
	private int pro_nStkAlto;				//stock para nivel alto
	private int pro_nStkBajo;				//stock para nivel bajo
	private char pro_stat;					//estado
	
	final static int CUMPLEMIN_0 = 0;
	final static int CUMPLEMIN_1 = 1;
	final static int CUMPLEMIN_5 = 5;
	final static int CUMPLEMIN_10 = 10;
	final static int CUMPLEMAX_100 = 100;
	final static int CUMPLEMAX_2000 = 2000;
	
	
	/**
	 * Constructor tiene que llamar a los setters
	 */
	public Producto() {
		super();
	}

	/**
	 * Getter codigo producto
	 * @return
	 */
	public String getId_producto() {
		return id_producto;
	}

	/**
	 * Setter codigo producto
	 * @param id_producto
	 * @throws DomainException
	 */
	public void setId_producto(String id_producto) throws DomainException {
		if(Validator.filtroProducto(id_producto) && Validator.cumpleLongitud(id_producto, CUMPLEMIN_5, CUMPLEMIN_5)) {
			this.id_producto = id_producto;
		}else {
            throw new DomainException();
		}
	}

	/**
	 * Getter descripcion corta
	 * @return
	 */
	public String getPro_descripcion() {
		return pro_descripcion;
	}

	/**
	 * Setter descripcion corta
	 * @param pro_descripcion
	 * @throws DomainException
	 */
	public void setPro_descripcion(String pro_descripcion) throws DomainException {
		if(Validator.cumpleLongitud(pro_descripcion, CUMPLEMIN_5, CUMPLEMAX_100)) { 
			this.pro_descripcion = pro_descripcion;
		}else {
            throw new DomainException();
		}
	}

	/**
	 * Getter explicación
	 * @return
	 */
	public String getPro_desLarga() {
		return pro_desLarga;
	}

	/**
	 * Setter explicación
	 * @param pro_desLarga
	 * @throws DomainException
	 */
	public void setPro_desLarga(String pro_desLarga) throws DomainException {
		if(Validator.cumpleLongitud(pro_desLarga, CUMPLEMIN_5, CUMPLEMAX_2000)) {
			this.pro_desLarga = pro_desLarga;
		}else {
            throw new DomainException();
		}
	}

	/**
	 * Getter precio
	 * @return
	 */
	public double getPro_precio() {
		return pro_precio;
	}

	/**
	 * Setter precio
	 * @param pro_precio
	 * @throws DomainException
	 */
	public void setPro_precio(double pro_precio) throws DomainException {
		if(Validator.cumpleRango(pro_precio, CUMPLEMIN_0, CUMPLEMAX_100)) {
			this.pro_precio = pro_precio;
		}else {
            throw new DomainException();
		}
	}

	/**
	 * Getter stock
	 * @return
	 */
	public int getPro_stock() {
		return pro_stock;
	}

	/**
	 * Setter stock
	 * @param pro_stock
	 */
	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}

	/**
	 * Getter fecha prevista reposicion
	 * @return
	 */
	public LocalDate getPro_fecRepos() {
		return pro_fecRepos;
	}

	/**
	 * Setter fecha prevista reposicion
	 * @param pro_fecRepos
	 * @throws DomainException
	 */
	public void setPro_fecRepos(LocalDate pro_fecRepos) throws DomainException {
		if(Validator.valDateMax(pro_fecRepos, LocalDate.now())){
			this.pro_fecRepos = pro_fecRepos;
		}else {
            throw new DomainException();
		}
	}

	/**
	 * Getter fecha activacion
	 * @return
	 */
	public LocalDate getPro_fecActi() {
		return pro_fecActi;
	}

	/**
	 * Setter fecha activacion
	 * @param pro_fecActi
	 * @throws DomainException
	 */
	public void setPro_fecActi(LocalDate pro_fecActi) throws DomainException {
		if(Validator.valDateMax(pro_fecRepos, LocalDate.now())){
			this.pro_fecActi = pro_fecActi;
		}else {
            throw new DomainException();
		}
	}

	/**
	 * Getter fecha desactivación
	 * @return
	 */
	public LocalDate getPro_FecDesacti() {
		return pro_fecDesacti;
	}

	/**
	 * Setter fecha desactivación
	 * @param pro_fecDesacti
	 * @throws DomainException
	 */
	public void setPro_FecDesacti(LocalDate pro_fecDesacti) throws DomainException { //revisar
		if(getPro_fecActi() != null) {
			Validator.valDateMax(pro_fecDesacti, pro_fecActi);
			this.pro_fecDesacti = pro_fecDesacti;
		}else if(Validator.valDateMax(pro_fecDesacti, LocalDate.now())) {
			this.pro_fecDesacti = pro_fecDesacti;
		}else {
            throw new DomainException();
		}
		
	}

	/**
	 * Getter unidad de venta
	 * @return
	 */
	public String getPro_uniVenta() {
		return pro_uniVenta;
	}

	/**
	 * Setter unidad de venta
	 * @param pro_uniVenta
	 * @throws DomainException
	 */
	public void setPro_uniVenta(String pro_uniVenta) throws DomainException {
		if(Validator.isAlfanumeric(pro_uniVenta) && Validator.cumpleLongitud(pro_uniVenta, CUMPLEMIN_1, CUMPLEMIN_10)) {
			this.pro_uniVenta = pro_uniVenta;
		}else {
            throw new DomainException();
		}
	}

	/**
	 * Getter cantidad de unidades ultimas
	 * @return
	 */
	public double getPro_cantXUniVenta() {
		return pro_cantXUniVenta;
	}

	/**
	 * Setter cantidad de unidades ultimas
	 * @param pro_cantXUniVenta
	 */
	public void setPro_cantXUniVenta(double pro_cantXUniVenta) {
		this.pro_cantXUniVenta = pro_cantXUniVenta;
	}

	/**
	 * Getter unidad ultima
	 * @return
	 */
	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}

	/**
	 * Setter unidad ultima
	 * @param pro_uniUltNivel
	 */
	public void setPro_uniUltNivel(String pro_uniUltNivel) {
		this.pro_uniUltNivel = pro_uniUltNivel;
	}

	/**
	 * Getter pais de origen
	 * @return
	 */
	public int getId_pais() { 
		return id_pais;
	}

	/**
	 * Setter pais de origen
	 * @param id_pais
	 */
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}

	/**
	 * Getter uso recomendado
	 * @return
	 */
	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}

	/**
	 * Setter uso recomendado
	 * @param pro_usoRecomendado
	 */
	public void setPro_usoRecomendado(String pro_usoRecomendado) {
		this.pro_usoRecomendado = pro_usoRecomendado;
	}

	/**
	 * Getter categoria
	 * @return
	 */
	public int getId_categoria() {
		return id_categoria;
	}

	/**
	 * Setter categoria
	 * @param id_categoria
	 */
	public void setId_categoria(int id_categoria) { // Existencia en lista paises (Base de datos)
		this.id_categoria = id_categoria;
	}

	/**
	 * Getter stock reservado
	 * @return
	 */
	public int getPro_stkReservado() {
		return pro_stkReservado;
	}

	/**
	 * Setter stock reservado
	 * @param pro_stkReservado
	 */
	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}

	/**
	 * Getter stock para nivel alto
	 * @return
	 */
	public int getPro_nStkAlto() {
		return pro_nStkAlto;
	}

	/**
	 * Setter stock para nivel alto
	 * @param pro_nStkAlto
	 */
	public void setPro_nStkAlto(int pro_nStkAlto) {
		this.pro_nStkAlto = pro_nStkAlto;
	}

	/**
	 * Getter stock para nivel bajo
	 * @return
	 */
	public int getPro_nStkBajo() {
		return pro_nStkBajo;
	}

	/**
	 * Setter stock para nivel bajo
	 * @param pro_nStkBajo
	 */
	public void setPro_nStkBajo(int pro_nStkBajo) {
		this.pro_nStkBajo = pro_nStkBajo;
	}

	/**
	 * getter de pro_stat
	 * @return
	 */
	public char getPro_stat() {
		return pro_stat;
	}

	/**
	 * Setter para pro_stat
	 * @param pro_stat
	 * @throws DomainException
	 */
	public void setPro_stat(char pro_stat) throws DomainException { 
	if(Validator.cumpleRango(pro_stat, CUMPLEMIN_1, CUMPLEMIN_1) && (pro_stat == 'A' || pro_stat == 'B')) {
		this.pro_stat = pro_stat;
		}else throw new DomainException("El estado ha de ser A - alta o B - baja");
	}

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", pro_descripcion=" + pro_descripcion + ", pro_desLarga="
				+ pro_desLarga + ", pro_precio=" + pro_precio + ", pro_stock=" + pro_stock + ", pro_fecRepos="
				+ pro_fecRepos + ", pro_fecActi=" + pro_fecActi + ", pro_fecDesacti=" + pro_fecDesacti + ", pro_uniVenta="
				+ pro_uniVenta + ", pro_cantXUniVenta=" + pro_cantXUniVenta + ", pro_uniUltNivel=" + pro_uniUltNivel
				+ ", id_pais=" + id_pais + ", pro_usoRecomendado=" + pro_usoRecomendado + ", id_categoria="
				+ id_categoria + ", pro_stkReservado=" + pro_stkReservado + ", pro_nStkAlto=" + pro_nStkAlto
				+ ", pro_nStkBajo=" + pro_nStkBajo + ", pro_stat=" + pro_stat + "]";
	}


}
