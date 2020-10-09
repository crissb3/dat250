package model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Poll poll;

    @ManyToOne
    private User user;
}