package com.project.library.services.exceptions;

import com.project.library.entities.Category;
import com.project.library.repositories.CategoryRepository;

public class DeleteException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private CategoryRepository categoryRepository;
	
	public DeleteException(Object id) {
		super("Não foi possível deletar pois o objeto selecionado está vinculado a outro objeto.");
	}
}
