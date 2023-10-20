package nl.youngcapital.birds.service;

import java.util.List;
import java.util.Optional;

import nl.youngcapital.birds.model.Egg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.birds.model.Bird;
import nl.youngcapital.birds.persistence.BirdRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BirdService {
	
	@Autowired
	private BirdRepository birdRepository;
	
	
	public List<Bird> findAll() {
		return birdRepository.findAll();
	}


	@Transactional
	public Bird createOrUpdate(Bird bird) {
		/*
		Be clear: this saving is MANDATORY since the @Cascade annotation in Bird only! works
		when the Egg is already a saved (attached) entity
		Detached ::= the entity is NOT yet saved to the DB and has id 0 (zero)
		Attached ::= The entity is SAVED to the DB and has an id other than 0 (zero)
		 */
		for (Egg egg : bird.getEggs()) {
			egg.setBird(bird);
		}

		return this.birdRepository.save(bird);
	}

	public List<Bird> findBirdsByColor(String color) {
		return birdRepository.findBirdsByColor(color);
	}

	public Optional<Bird> findById(long id) {
		return this.birdRepository.findById(id);
	}
	
	public void deleteById(long id) {
		this.birdRepository.deleteById(id);
	}
}
