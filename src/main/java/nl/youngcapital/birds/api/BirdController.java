package nl.youngcapital.birds.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nl.youngcapital.birds.model.Bird;
import nl.youngcapital.birds.service.BirdService;

@RestController
@CrossOrigin
@RequestMapping("api/birds")
public class BirdController {
	
	@Autowired
	private BirdService birdService;
	
	@GetMapping // listens to: http://localhost:8080/api/birds
	public List<Bird> findAll() {
		return birdService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Bird> create(@RequestBody Bird bird) {
		return ResponseEntity.status(201).body(this.birdService.createOrUpdate(bird));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Bird> findById(@PathVariable long id) {
		Optional<Bird> optionalBird = this.birdService.findById(id);
		
		if(optionalBird.isPresent()) {
			Bird result = optionalBird.get();

			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Bird> updateById(@PathVariable long id, @RequestBody Bird input) {
		Optional<Bird> optionalTarget = this.birdService.findById(id);
		
		if(optionalTarget.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Bird target = optionalTarget.get();
		target.setName(input.getName());
		target.setColor(input.getColor());
		target.setWeight(input.getWeight());

		Bird updated =this.birdService.createOrUpdate(target);

		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id) {
		this.birdService.deleteById(id);

		return ResponseEntity.noContent().build();
	}
}
