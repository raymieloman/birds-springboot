package nl.youngcapital.birds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.birds.model.Bird;
import nl.youngcapital.birds.persistence.BirdRepository;

@Service
public class BirdService {
	
	@Autowired
	private BirdRepository birdRepository;
	
	
	public Iterable<Bird> findAll() {
		
		return birdRepository.findAll();
	}
}
