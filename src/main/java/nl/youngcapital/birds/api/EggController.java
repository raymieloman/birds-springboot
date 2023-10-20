package nl.youngcapital.birds.api;

import nl.youngcapital.birds.model.Egg;
import nl.youngcapital.birds.service.EggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/eggs")
public class EggController {
	
	@Autowired
	private EggService eggService;
	
	@GetMapping // listens to: http://localhost:8080/api/eggs
	public List<Egg> findAll() {
		return eggService.findAll();
	}
	
	@PostMapping
	public Egg create(@RequestBody Egg egg) {
		return this.eggService.createOrUpdate(egg);
	}
	
	@GetMapping("{id}")
	public Egg findById(@PathVariable long id) {
		Optional<Egg> optionalEgg = this.eggService.findById(id);
		
		if(optionalEgg.isPresent()) {
			return optionalEgg.get();
		} else {
			return null; // zo moet het niet, later anders ... TODO
		}
	}
	
	@PutMapping("{id}")
	public Egg updateById(@PathVariable long id, @RequestBody Egg input) {
		Egg target = findById(id);
		
		if(target ==null) {
			return null;
		}
		target.setColor(input.getColor());
		target.setWeight(input.getWeight());

		return this.eggService.createOrUpdate(target);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable long id) {
		this.eggService.deleteById(id);
	}
}
