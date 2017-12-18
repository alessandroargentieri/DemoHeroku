package com.quicktutorialz.learnmicroservices.DemoHeroku;

import com.quicktutorialz.learnmicroservices.DemoHeroku.daos.AuthorDao;
import com.quicktutorialz.learnmicroservices.DemoHeroku.daos.BookDao;
import com.quicktutorialz.learnmicroservices.DemoHeroku.entities.Author;
import com.quicktutorialz.learnmicroservices.DemoHeroku.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@RestController
@SpringBootApplication
public class DemoHerokuApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoHerokuApplication.class, args);
	}

	@Autowired AuthorDao authorDao;
	@Autowired BookDao bookDao;

	@RequestMapping("/")
	public String hello(){
		return "Hello!";
	}

	@RequestMapping("/books")
	public List<Book> getBooks(){
		return bookDao.findAll();
	}

	@RequestMapping("/books/{id}")
	public Book getOneBook(@PathVariable(name = "id") Integer id){
		return bookDao.findOne(id);
	}

	@RequestMapping("/authors")
	public List<Author> getAuthors(){
		return authorDao.findAll();
	}

	@RequestMapping("/authors/{id}")
	public Author getOneAuthor(@PathVariable(name = "id") Integer id){
		return authorDao.findOne(id);
	}

	@RequestMapping("/books/save")
	public Book saveBook(@Valid Book book){
		return bookDao.save(book);
	}

	@RequestMapping("/books/delete/{id}")
	public List<Book> deleteBook(@PathVariable(name = "id") Integer id){
		bookDao.delete(id);
		return bookDao.findAll();
	}

	@RequestMapping("/authors/save")
	public Author saveAuthor(@Valid Author author){
		return authorDao.save(author);
	}

	@RequestMapping("/authors/delete/{id}")
	public List<Author> deleteAuthor(@PathVariable(name = "id") Integer id){
		authorDao.delete(id);
		return authorDao.findAll();
	}

	/*@PostConstruct
	private void fillDatabase(){
		authorDao.save(new Author(null, "Gino Camarda", "gino@quicktutorialz.com"));
		authorDao.save(new Author(null, "Attilia Nomeldini", "attilia@quicktutorialz.com"));

		bookDao.save(new Book(null, "Il basket per me", "Saggio sportivo", null, 1));
		bookDao.save(new Book(null, "W il basket", "Saggio sportivo", null, 1));

		bookDao.save(new Book(null, "Giornali e pareri", "Saggio giornalistico", null, 2));
		bookDao.save(new Book(null, "Versioni della verita", "Saggio giornalistico", null, 2));

	}*/


}
