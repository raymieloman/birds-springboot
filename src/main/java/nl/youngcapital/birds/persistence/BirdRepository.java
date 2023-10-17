package nl.youngcapital.birds.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.youngcapital.birds.model.Bird;


@Repository
public interface BirdRepository extends CrudRepository<Bird, Long> {

}
