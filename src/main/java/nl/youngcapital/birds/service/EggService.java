package nl.youngcapital.birds.service;

import nl.youngcapital.birds.model.Egg;
import nl.youngcapital.birds.persistence.EggRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EggService {
	
	@Autowired
	private EggRepository eggRepository;
	
	
	public List<Egg> findAll() {
		return eggRepository.findAll();
	}


	public Egg createOrUpdate(Egg egg) {
		return this.eggRepository.save(egg);
	}
	


	public Optional<Egg> findById(long id) {
		return this.eggRepository.findById(id);
	}
	
	public void deleteById(long id) {
		this.eggRepository.deleteById(id);
	}
}
