package com.quicktutorialz.learnmicroservices.DemoHeroku.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity @Table(name="books")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Book {
    @Id @Column(name="ID") @GeneratedValue
    private Integer id;
    @Column(name="TITLE") @NotBlank
    private String title;
    @Column(name="TITLE") @NotBlank
    private String description;
    @Column(name="TITLE")
    private Date dateOfRelease;
    @Column(name="TITLE") @NotNull
    private int authorId;

    @PrePersist
    private void setDate(){
        this.dateOfRelease = new Date();
    }
}
