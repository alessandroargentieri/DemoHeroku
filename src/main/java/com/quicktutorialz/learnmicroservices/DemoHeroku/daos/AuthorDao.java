package com.quicktutorialz.learnmicroservices.DemoHeroku.daos;

import com.quicktutorialz.learnmicroservices.DemoHeroku.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Integer>{

}
