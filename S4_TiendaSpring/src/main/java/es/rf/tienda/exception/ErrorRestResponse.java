package es.rf.tienda.exception;

import org.springframework.http.HttpStatus;

public class ErrorRestResponse {
	private Exception excepcion;
	private String mensaje;
	private HttpStatus httpR;
	
	public ErrorRestResponse() {
		super();
	}

	public ErrorRestResponse(Exception excepcion, String mensaje, HttpStatus httpR) {
		super();
		this.excepcion = excepcion;
		this.mensaje = mensaje;
		this.httpR = httpR;
	}
	
	public Exception getExcepcion() {
		return excepcion;
	}

	public void setExcepcion(Exception excepcion) {
		this.excepcion = excepcion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public HttpStatus getHttpR() {
		return httpR;
	}

	public void setHttpR(HttpStatus httpR) {
		this.httpR = httpR;
	}

	@Override
	public String toString() {
		return "ErrorRestResponse [excepcion=" + excepcion + ", mensaje=" + mensaje + ", httpR=" + httpR + "]";
	}
	
	
	
	
	
}
