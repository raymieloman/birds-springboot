package nl.youngcapital.birds.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.youngcapital.birds.model.Bird;
import nl.youngcapital.birds.service.BirdService;

@RestController
@RequestMapping("api/birds")
public class BirdController {
	
	@Autowired
	private BirdService birdService;
	
	@GetMapping // listens to: http://localhost:8080/api/birds
	public List<Bird> findAll() {
		return birdService.findAll();
	}
	
	@PostMapping
	public Bird create(@RequestBody Bird bird) {
		return this.birdService.createOrUpdate(bird);
	}
	
	@GetMapping("{id}")
	public Bird findById(@PathVariable long id) {
		Optional<Bird> optionalBird = this.birdService.findById(id);
		
		if(optionalBird.isPresent()) {
			return optionalBird.get();
		} else {
			return null; // zo moet het niet, later anders ... TODO
		}
	}
	
	@PutMapping("{id}")
	public Bird updateById(@PathVariable long id, @RequestBody Bird input) {
		Bird target = findById(id);
		
		if(target ==null) {
			return null;
		}
		target.setName(input.getName());
		target.setColor(input.getColor());
		target.setWeight(input.getWeight());
		
		return this.birdService.createOrUpdate(target);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable long id) {
		this.birdService.deleteById(id);
	}
}
