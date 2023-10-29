package com.project.library.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.library.entities.Adress;
import com.project.library.entities.Book;
import com.project.library.entities.Category;
import com.project.library.entities.Reader;
import com.project.library.entities.Users;
import com.project.library.format.DateFormat;
import com.project.library.repositories.AdressRepository;
import com.project.library.repositories.BookRepository;
import com.project.library.repositories.CategoryRepository;
import com.project.library.repositories.ReaderRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	DateFormat format = new DateFormat();
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ReaderRepository readerRepository;
	
	@Autowired
	private AdressRepository adressRepository;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Category cat1 = new Category(null, "Programação");
		Category cat2 = new Category(null, "Redes");
		Category cat3 = new Category(null, "Administração");
		Category cat4 = new Category(null, "Física");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		
		Book b1 = new Book(null, "programação java", "auth1" , "2", 5);
		Book b2 = new Book(null, "fisica 2", "auth2" , "1", 10);
		Book b3 = new Book(null, "ADM", "auth3" , "7", 40);
		Book b4 = new Book(null, "programação web", "auth4" , "1", 2);
		
		b1.setCategory(cat1);
		b2.setCategory(cat4);
		b3.setCategory(cat3);
		b4.setCategory(cat1);
		
		bookRepository.saveAll(Arrays.asList(b1,b2,b3,b4));
		
		
		Users re1 = new Reader(null, "halan Caio Pereira do Nascimento", "Hallan", 
				"583454", format.formatToDate("17/06/2001"), "8954589", "hfesfdsop", "23432fdsf");
		
		Users re2 = new Reader(null, "Carlos Eduardo", "Dudu", 
				"753475", format.formatToDate("16/02/2003"), "6547", "hfesf6fgwgdsop", "gfdwg546");
		
		Users re3 = new Reader(null, "Guilherme Roque", "Gui", 
				"65465", format.formatToDate("1/10/1997"), "54646", "gfshh5646", "fgshhsy");
		
		Adress ad1 = new Adress(null, "Rua 1", 4, "centro", "59350000", "Santana do seridó", "Rio Grande do Norte");
		Adress ad2 = new Adress(null, "Avenida 2", 7, "bairro 2", "59870000", "Cidade 2", "Rio de Janeiro");
		Adress ad3 = new Adress(null, "Praça 3", 12, "zona rural", "70123456", "Cidade 3", "São Paulo");
		
		adressRepository.saveAll(Arrays.asList(ad1,ad2,ad3));
		
		re1.setAdress(ad1);
		re2.setAdress(ad2);
		re3.setAdress(ad3);
		
		readerRepository.saveAll(Arrays.asList(re1, re2, re3));

	}

	
}
