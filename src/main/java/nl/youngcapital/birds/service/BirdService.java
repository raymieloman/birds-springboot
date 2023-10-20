package nl.youngcapital.birds.service;

import java.util.List;
import java.util.Optional;

import nl.youngcapital.birds.model.Egg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.birds.model.Bird;
import nl.youngcapital.birds.persistence.BirdRepository;

@Service
public class BirdService {
	
	@Autowired
	private BirdRepository birdRepository;
	
	
	public List<Bird> findAll() {
		return birdRepository.findAll();
	}


	public Bird createOrUpdate(Bird bird) {
		// NB set in the egg, the bird to this one
		for (Egg egg : bird.getEggs()) {
			egg.setBird(bird);

		}
		return this.birdRepository.save(bird);
	}
	


	public Optional<Bird> findById(long id) {
		return this.birdRepository.findById(id);
	}
	
	public void deleteById(long id) {
		this.birdRepository.deleteById(id);
	}
}
