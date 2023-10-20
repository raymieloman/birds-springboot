package nl.youngcapital.birds.model;

import jakarta.persistence.*;

@Entity
public class Nest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private double latitude;
    private double longitude;

    @OneToOne(mappedBy = "nest")
    private Bird bird;

}
