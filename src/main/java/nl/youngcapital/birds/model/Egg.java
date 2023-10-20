package nl.youngcapital.birds.model;

import jakarta.persistence.*;

@Entity
public class Egg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String color;
    private double weight;

    @ManyToOne
    private Bird bird;

    public long getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }
}
