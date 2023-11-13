package com.project.library.services;

import static org.junit.jupiter.api.Assertions.*;
import com.project.library.entities.Book;
import com.project.library.entities.Category;
import com.project.library.repositories.BookRepository;
import com.project.library.repositories.CategoryRepository;
import com.project.library.services.exceptions.DeleteException;
import com.project.library.services.exceptions.ResourceNotFoundException;

import java.util.List;

import org.checkerframework.checker.optional.qual.Present;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class BookServiceTest {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryService categoryService;

	
	@Test
	public void TestarSeRetornaTodosOsLivrosDoBanco() {
		List<Book> ListaDeLivros = bookService.findAll();
		List<Book> esperado = bookRepository.findAll();
		assertEquals(esperado, ListaDeLivros);
		assertNotNull(ListaDeLivros);
		System.out.println(esperado);
		System.out.println(ListaDeLivros);
		System.out.println("-------------------------------------");
		
	}
	@Test
	public void TestarSeRetornaUmLivroBuscandoPeloID(){
		Book LivroId1 = bookService.findByid((long)1);
		Book esperado = bookRepository.findById((long)1).get();
 		assertEquals(esperado, LivroId1);
 		System.out.println(esperado);
 		System.out.println(LivroId1);
 		System.out.println("aaaaaaaaaaaaaaaaaaaaa");		
	}
	@Test
	public void TestarSeAdicionouUmLivro() {
		Book LivroTeste = new Book(null, "c++ iniciante", "Guilherme", "1", 3);
		Category categoria = new Category(null, "engenharia");
		LivroTeste.setCategory(categoria);
		bookService.addBook(LivroTeste);
		Book esperado = bookRepository.findById((long)5).get();
		assertEquals(esperado, LivroTeste);
		System.out.println(esperado);
		System.out.println(LivroTeste);
		System.out.println("***************");
	}
	@Test
	public void TestarSeUmLivroFoiDeletado() {

		long LivroASerDeletado = bookService.findByid(5L).getId();
		List<Book> esperado = bookRepository.findAll();
		bookService.deleteBook(LivroASerDeletado);
		List<Book> ListaLivros = bookRepository.findAll();
		assertNotEquals(esperado, ListaLivros);
		assertTrue(esperado.size() - 1 == ListaLivros.size());
//		assertThrows(ResourceNotFoundException.class,()-> bookService.deleteBook(9L));
		assertThrows(DeleteException.class,()-> bookService.deleteBook(1L));

		System.out.println(esperado);
		System.out.println(ListaLivros);
		System.out.println("///////////////////////////////");
		
	}
	@Test
	public void TestarSeLivroFoiAtualizado() {
		
		Book LivroAtualizar = new Book(1L, "python", "guilherme", "5", 7);
		Category nova = new Category(null, "programação");
		categoryService.addCategory(nova);
		LivroAtualizar.setCategory(nova);
		bookService.updateBook(1L, LivroAtualizar);
		Book LivroAtualizado = bookRepository.findById(1L).get();
		assertEquals(LivroAtualizar, LivroAtualizado);	
	}

	
}

