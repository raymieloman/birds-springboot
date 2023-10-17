package nl.youngcapital.birds.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
		return this.birdService.create(bird);
	}
}
