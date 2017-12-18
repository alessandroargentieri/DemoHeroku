package com.quicktutorialz.learnmicroservices.DemoHeroku.daos;

import com.quicktutorialz.learnmicroservices.DemoHeroku.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Integer>{
}
