package nl.youngcapital.birds.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Bird {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String name;

	private double weight;
	private String color;

	@OneToMany(mappedBy = "bird")
	@JsonIgnoreProperties("bird")
	@Cascade(CascadeType.ALL)
	private Set<Egg> eggs = new HashSet<>();

	@OneToOne
	private Nest nest;

	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public Set<Egg> getEggs() {
		return eggs;
	}

	public void setEggs(Set<Egg> eggs) {
		this.eggs = eggs;
	}

	public Nest getNest() {
		return nest;
	}

	public void setNest(Nest nest) {
		this.nest = nest;
	}
}
