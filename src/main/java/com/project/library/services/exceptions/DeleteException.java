package com.project.library.services.exceptions;

public class DeleteException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DeleteException(Object id) {
		super("Não foi possível deletar pois o objeto selecionado está vinculado a outro objeto.");
	}
}
