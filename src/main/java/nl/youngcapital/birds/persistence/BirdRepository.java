package nl.youngcapital.birds.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.youngcapital.birds.model.Bird;


@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {

}
