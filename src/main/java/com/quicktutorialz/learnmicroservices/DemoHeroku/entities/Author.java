package com.quicktutorialz.learnmicroservices.DemoHeroku.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity @Table(name="authors") @AllArgsConstructor @NoArgsConstructor  @Getter @Setter
public class Author {

    @Id @Column(name="ID") @GeneratedValue
    private Integer id;
    @Column(name="NAME") @NotBlank
    private String name;
    @Column(name="EMAIL") @NotBlank
    private String email;
}
