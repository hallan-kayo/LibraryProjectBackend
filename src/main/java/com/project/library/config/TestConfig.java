package com.project.library.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.project.library.entities.Adress;
import com.project.library.entities.Book;
import com.project.library.entities.Category;
import com.project.library.entities.Reader;
import com.project.library.entities.Reader;
import com.project.library.entities.Manager;
import com.project.library.entities.Reader;
import com.project.library.entities.Reserve;
import com.project.library.entities.Reserve;
import com.project.library.entities.Users;
import com.project.library.format.DateFormat;
import com.project.library.repositories.AdressRepository;
import com.project.library.repositories.BookRepository;
import com.project.library.repositories.CategoryRepository;
import com.project.library.repositories.ManagerRepository;
import com.project.library.repositories.ReaderRepository;
import com.project.library.repositories.ReserveRepository;


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
	
	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
	private ReserveRepository reserveRepository;
	
	
	
	
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
		
		
		Reader re1 = new Reader(null, "halan Caio Pereira do Nascimento", "Hallan", 

				"583454", format.formatToDate("17/06/2001"), "8954589", "hfesfdsop", "23432fdsf");

		
		Reader re2 = new Reader(null, "Carlos Eduardo", "Dudu", 
				"753475", format.formatToDate("16/02/2003"), "6547", "hfesf6fgwgdsop", "gfdwg546");
		
		Reader re3 = new Reader(null, "Guilherme Roque", "Gui", 
				"65465", format.formatToDate("1/10/1997"), "54646", "gfshh5646", "fgshhsy");
		
		Reader re4 = new Reader(null, "Francisco Gabriel", "Chico",
				"31321", format.formatToDate("1/11/1996"), "32312313", "chico32131", "uepb3213");
		
		Reader re5 = new Reader(null, "Maria da Silva", "Maria",
                "54321", format.formatToDate("5/5/1990"), "55555555", "maria32131", "uepb9876");
		
		Reader re6 = new Reader(null, "João Pereira", "João",
                "98765", format.formatToDate("10/3/1985"), "99999999", "joao9876", "uepb5432");
		
		Reader re7 = new Reader(null, "Ana Silva", "Ana",
                "87654", format.formatToDate("12/8/1992"), "77777777", "ana12345", "uepb6543");
		
		Reader re8 = new Reader(null, "Pedro Oliveira", "Pedro",
                 "12345", format.formatToDate("3/2/2000"), "88888888", "pedro54321", "uepb7890");
		
		Reader re9 = new Reader(null, "Mariana Santos", "Mariana",
                "45678", format.formatToDate("7/6/1998"), "66666666", "mariana98765", "uepb4321");
		
		Reader re10 = new Reader(null, "Vitoria Candeia", "Viiica", 
				"323123", format.formatToDate("3/10/1998"), "123122321", "vitoriaviica321", "viksp231");


				
		Adress ad1 = new Adress(null, "Rua 1", 4, "centro", "59350000", "Santana do seridó", "Rio Grande do Norte");
		Adress ad2 = new Adress(null, "Avenida 2", 7, "bairro 2", "59870000", "Cidade 2", "Rio de Janeiro");
		Adress ad3 = new Adress(null, "Praça 3", 12, "zona rural", "70123456", "Cidade 3", "São Paulo");
		Adress ad4 = new Adress(null, "Rua bossuet", 23, "brasilia", "58700410", "patos", "paraiba");
		Adress ad5 = new Adress(null, "Rua epitacio pessoa", 240, "centro", "58700420", "patos", "paraiba");
		Adress ad6 = new Adress(null, "Rua quirino ribeiro", 213, "centro", "58720000", "santa terezinha", "paraiba");
		Adress ad7 = new Adress(null, "Rua jose nunes", 132, "centro", "58720970", "santa terezinha", "paraiba");
		Adress ad8 = new Adress(null, "Rua Felizardo Leite", 983, "centro", "58700460", "patos", "paraiba");
		Adress ad9 = new Adress(null, "Rua do Meio", 827, "Liberdade", "58703008", "patos", "paraiba");
		Adress ad10 = new Adress(null, "Rua do Prado", 928, "Liberdade", "58703000", "patos", "paraiba");

	
		
		
		Manager ma1 = new Manager(null, "Andressa Leite", "Andressa", 
				"23131223", format.formatToDate("23/11/1986"), "98392813", "andressa231233", "kl32131");
		
		Manager ma2 = new Manager(null, "Gabriel Otton", "Biel", 
				"789321873", format.formatToDate("01/12/2002"), "9321313213", "biel321312", "lol3213");
		
		Manager ma3 = new Manager(null, "Serjao dos Foguetes", "Serjao", 
				"93829183", format.formatToDate("21/09/1973"), "38921389", "serjaoeclipse32321", "projetinho3213");
		
		
		Adress mad1 = new Adress(null, "Rua Dinamerico Almeida", 1002, "Salgadinho", "58706588", "patos", "paraiba");
		Adress mad2 = new Adress(null, "Rua Pedro arruda", 928, "Centro", "58993970", "Boa Ventura", "paraiba");
		Adress mad3 = new Adress(null, "Rua de Marte", 8888, "Marte", "1111111", "Marte", "Paraiba");
		
		
        adressRepository.saveAll(Arrays.asList(ad1, ad2, ad3, ad4, ad5, ad6, ad7, ad8, ad9, ad10, mad1, mad2, mad3));
		
		re1.setAdress(ad1);
		re2.setAdress(ad2);
		re3.setAdress(ad3);
		re4.setAdress(ad4);
		re5.setAdress(ad5);
		re6.setAdress(ad6);
		re7.setAdress(ad7);
		re8.setAdress(ad8);
		re9.setAdress(ad9);
		re10.setAdress(ad10);
		ma1.setAdress(mad1);
		ma2.setAdress(mad2);
		ma3.setAdress(mad3);
		
		readerRepository.saveAll(Arrays.asList(re1, re2, re3, re4, re5, re6, re7, re8, re9, re10));
		
		managerRepository.saveAll(Arrays.asList(ma1, ma2, ma3));
		

		Reserve r1 = new Reserve(null, Instant.now());
        Reserve r2 = new Reserve(null, Instant.now());
		
		r1.setBook(b1);
		r1.setLinkedReader(re1);
		r2.setBook(b2);
		r2.setLinkedReader(re2);
		reserveRepository.saveAll(Arrays.asList(r1, r2));
	}

	
}
