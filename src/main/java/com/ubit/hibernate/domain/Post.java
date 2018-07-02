package com.ubit.hibernate.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String description;

    private String text;

    @Temporal(TemporalType.DATE)
    private Date date;

    public Post(String description, String text, Date date) {
        this.description = description;
        this.text = text;
        this.date = date;
    }
}
