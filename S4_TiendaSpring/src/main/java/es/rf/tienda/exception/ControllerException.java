package es.rf.tienda.exception;

public class ControllerException extends Exception{

	public ControllerException() {
		super("Error Controller Exception");
	}
	
	public ControllerException(String arg0) {
		super("Controller Exception:" + arg0);
	}
	
}
