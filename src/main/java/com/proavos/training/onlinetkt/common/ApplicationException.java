package com.proavos.training.onlinetkt.common;

@javax.ejb.ApplicationException(rollback=true)
public class ApplicationException extends Exception {

	private static final long serialVersionUID = 2939825928922450568L;

	public ApplicationException(String message) {
		super(message);
	}


	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

}
