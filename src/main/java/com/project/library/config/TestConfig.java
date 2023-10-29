package com.project.library.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.library.entities.Category;
import com.project.library.repositories.AdressRepository;
import com.project.library.repositories.CategoryRepository;
import com.project.library.repositories.ReaderRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

//	DateFormat format = new DateFormat();
	
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
//		Users re1 = new Reader(null, "halan Caio Pereira do Nascimento", "Hallan", 
//				"583454", format.formatToDate("17/06/2001"), "8954589", "hfesfdsop", "23432fdsf");
//		
//		Users re2 = new Reader(null, "Carlos Eduardo", "Dudu", 
//				"753475", format.formatToDate("16/02/2003"), "6547", "hfesf6fgwgdsop", "gfdwg546");
//		
//		Users re3 = new Reader(null, "Guilherme Roque", "Gui", 
//				"65465", format.formatToDate("1/10/1997"), "54646", "gfshh5646", "fgshhsy");
//		
//		readerRepository.saveAll(Arrays.asList(re1, re2, re3));
		
//		Adress ad1 = new Adress()
		
	}

	
}
