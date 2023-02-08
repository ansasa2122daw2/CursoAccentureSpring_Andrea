package es.rf.tienda.exception;

@SuppressWarnings("serial")
public class DomainException extends Exception {
	
	public DomainException() {
		super("Error Domain Exception");
	}
	
	public DomainException(String arg0) {
		super("Domain Exception:" + arg0);
	}
	

}
