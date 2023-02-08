package es.rf.tienda.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



/********************************************************************************************
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: 
 * 			Clase auxiliar para validar los datos que sean 
 * 			introducidos en la aplicación.
 * 
 *  @version	27/01/2023
 *  @author 	Andrea Sánchez
 *  
 * ******************************************************************************************/
public class Validator {
	
	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z\\s]+$";
	
	private static final String PASSWORD_PATTERN = 
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})";
	/**
	 * Patrón para validar el email, evitando puntos finales antes de la @ y que solo contenga
	 * carácteres alfanuméricos		 
	 */
	private final static String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
	/**
	 * Permite verificar que un DNI cumple con el patrón XX.XXX.XXX-L
	 */
	private final static String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[a-zA-Z]";
		
	/**
	 * Permite validar un teléfono, el cual debe contener de 10 a 20 dígitos
	 * y donde los espacios estén permitidos
	 */
	private final static String PHONE_PATTERN =  "[\\d ]{10,20}";
	
	/**
	 * Orden de las letras con las cuales se comprobará la validez del DNI
	 */
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	/**
	 * Longitud que debe tener todo DNI pasado a la aplicación.
	 */
	private final static int LONGITUD_DNI = 12;
	
	/**
	 * Solo mayúsculas y números (2 mayusculas y tres números)
	 */
	private final static String PRODUCTO_PATTERN = "^[A-Z]{2}[0-9]{3}$";

	/** ***************************************************************************************
	 * NOMBRE: isAlfanumeric                                                                 *
	 * 
	 * DESCRIPCIÓN: 
	 * 		Permite verificar que el texto pasado solo contiene caracters alfanuméricos
	 * 
	 * @param texto String a verificar que solo tenga car�cteres alfanuméricos
	 * 
	 * @return  true, si cumple solo contiene caracters alfanuméricos. <br> 
	 * 			false en caso contrario
	 *	@version	27/01/2023
	 *  @author 	Andrea Sánchez
	 * 
	 * **************************************************************************************/
	public static boolean isAlfanumeric(String texto){
		if (texto.matches(ALFANUMERIC_PATTERN)) {
			return true;
		}
		return false;
	}
	
	public static boolean isVacio( String prueba ){
		if(prueba != null && prueba.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/** ***************************************************************************************
	 * NOMBRE: cumplePhoneNumber                                                                 *
	 * 
	 * DESCRIPCIÓN:
	 * 		El phone number debe tener un total de entre 10 y 20, contando dígitos y espacios.
	 * 		Mínimo aceptable son 10 dígitos.
	 * 
	 * @param phoneNumber String con el número de telefono de entre 10 y 20 dígitos. 
	 * 		Puede tener espacios, pero siempre con 10 dígitos como mínimo.
	 * 
	 * @return true, si cumple todas las condiciones
	 *
	 *	@version	27/01/2023
	 *  @author 	Andrea Sánchez
	 * 
	 * **************************************************************************************/
	public static boolean cumplePhoneNumber(String phoneNumber){
		if(phoneNumber.matches(PHONE_PATTERN)) {
			return true;
		}
		return false;
	}

	/** ***************************************************************************************
	 * NOMBRE: isEmailValido                                                                 *
	 * 
	 * DESCRIPCIÓN: 
	 * 			Comprueba si el email tiene un formato que pueda ser válido.
	 * 
	 * @param email String a comprobar
	 * 
	 * @return true, en caso que el formato sea válido
	 * 
	 *	@version	27/01/2023
	 *  @author 	Andrea Sánchez
	 * 
	 * **************************************************************************************/
	public static boolean isEmailValido(String email){
		if(email.matches(EMAIL_PATTERN)) {
			return true;
		}
		return false;
	}

	/** ***************************************************************************************
	 * NOMBRE: cumpleDNI                                                                 
	 * 
	 * DESCRIPCIÓN:
	 * 			Esta función verifica que el DNI cumple el siguiente formato: xx.xxx.xxx-L <br>
	 * 			El DNI ha de tener longitud 12
	 * 
	 * @param dni String con DNI a ser validado
	 * 
	 * @return true, si el DNI cumple el estandar nacional.
	 * 
	 *	@version	27/01/2023
	 *  @author 	Andrea Sánchez
	 * 
	 * **************************************************************************************/
	//REVISAR
	public static boolean cumpleDNI(String dni){
		Character letraDNI = Character.toUpperCase(dni.charAt(dni.length() -1));
		
		if(LETRA_DNI.charAt(LONGITUD_DNI %23) == letraDNI) {
			if(dni.matches(DNI_PATTERN) && (dni.length() == LONGITUD_DNI)) {
				return true;
			}
		}
		return false;
	}

	/** ***************************************************************************************
	 * NOMBRE: cumpleRango                                                                 *
	 * 
	 * DESCRIPCIÓN: 
	 * 		Comprueba que un Número se necuentra entre 2 valores
	 * 
	 * @param valor (int)/(double) Número a comprobar
	 * @param valorMinimo (int) Número valor aceptable
	 * @param valorMaximo (int) Número valor aceptable
	 * 
	 * @return true si valorMinimo < valor < valorMaximo
	 * 
	 *	@version	27/01/2023
	 *  @author 	Andrea Sánchez
	 * 
	 * **************************************************************************************/
	public static boolean cumpleRango(
			int valor, 
			int valorMinimo,
			int valorMaximo){
		if(!(valorMaximo > valor && valor > valorMinimo)) {
			return false;
		}
		return true;
		
	}
	public static boolean cumpleRango(
			double valor, 
			int valorMinimo,
			int valorMaximo){
		if(!(valorMaximo > valor && valor > valorMinimo)) {
			return false;
		}
		return true;	
	}

	/** ***************************************************************************************
	 * NOMBRE: cumpleLongitudMin                                                                 
	 * 
	 * DESCRIPCIÓN: 
	 * 		Comprobar que el texto pasado tiene una longitud de al menos x caracteres, siendo
	 * 		x el entero pasado como parámetro
	 * 
	 * @param texto String texto a comprobar
	 * @param longitudMinima int que indique longitud mínima.
	 * 
	 * @return cierto, si la longitud del texto es mayor o igual que longitudMinima
	 * 
	 *	@version	27/01/2023
	 *  @author 	Andrea Sánchez
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitudMin(
			String texto, 
			int longitudMinima){
		if(!(texto.length() >= longitudMinima)) {
			return false;
		}
		return true;	
	}
	
	/** ***************************************************************************************
	 * NOMBRE: cumpleLongitudMax                                                                 *
	 * 
	 * DESCRIPCIÓN: 
	 * 		Comprobar que el texto pasado tiene una longitud de, como mucho, x caracteres, siendo
	 * 		x el entero pasado como parámetro
	 * 
	 * @param texto String con el texto a comprobar
	 * @param longitudMaxima int con la longitud máxima del texto
	 * 
	 * @return true, si el texto es menor o igual que la longitud máxima.
	 * 
	 *	@version	27/01/2023
	 *  @author 	Andrea Sánchez
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitudMax(
			String texto, 
			int longitudMaxima){
		
		if(!(texto.length() <= longitudMaxima)) {
			return false;
		}
		return true;
	}

	/****************************************************************************************
	 * NOMBRE: cumpleLongitud                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Comprobar que la longitud de un texto se encuentra entre unos valores máximos y mínimos 
	 * 
	 * @param texto String con el texto que a validar
	 * @param longitudMinima (int) Mínima longitud del texto
	 * @param longitudMaxima (int) Máxima longitud válida para el texo
	 * 
	 * @return true, si la longitud del texto cumple: longitudMinima
	 *               <= longitudTexto <=longitudMaxima
	 *               
	 *	@version	27/01/2023
	 *  @author 	Andrea Sánchez
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitud(
			String texto, 
			int longitudMinima, 
			int longitudMaxima){
		if(!cumpleLongitudMin(texto,longitudMinima) && cumpleLongitudMax(texto,longitudMaxima)) {
			return false;
		}
		return true;
	}
	/**
	 * Valida una fecha calendar con m�nimo min
	 * @param fecha
	 * @param min
	 * @return
	 */
	
	public static boolean valDateMin(LocalDate fecha, LocalDate min){
		if(!min.isBefore(fecha)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Valida una fecha calendar con m�ximo max
	 * @param fecha
	 * @param max
	 * @return
	 */
	public static boolean valDateMax(LocalDate fecha, LocalDate max){
		if(!max.isAfter(fecha)) {
			return false;
		}
		return true;
	}	
	
	/**
	 * esFechaValida
	 * Recibe una string con formato fecha dd/mm/aaaa y comprueba el formato
	 * @param fecha
	 * @return
	 */
	//Hecho con RegEx
	public static boolean esFechaValida(String fecha){
		 String strPattern = "^\\d{2}/\\d{2}/\\d{4}$";
		 
		 if(fecha.matches(strPattern)) {
			 return true;
		 }
		return false;
	}
	
	/**
	 * Nombre esPasswordValida
	 * Descripcion Comprueba que la cadena recibida cumpla con lasnormas de contraseña
	 * @param password string con la contraseña introducida
	 * @return true si cumple con las especificaciones
	 */
	//contraseña minimo 6 caracteres contener una minuscula una mayuscula un digito y un simbolo

	public static boolean esPasswordValida(String password){
		if(!password.matches(PASSWORD_PATTERN)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Commit filtro Producto
	 * Solo 5 caracteres letras(en mayusculas) y numeros 
	 */
	public static boolean filtroProducto(String filtro) {
		if(!(filtro.matches(PRODUCTO_PATTERN))) {
			return false;
		}
		return true;
	}
	
}
