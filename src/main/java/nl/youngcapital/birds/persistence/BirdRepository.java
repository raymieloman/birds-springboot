package nl.youngcapital.birds.persistence;

import nl.youngcapital.birds.model.Nest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.youngcapital.birds.model.Bird;

import java.util.List;


@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {

    List<Bird> findBirdsByWeightIsGreaterThan(int minWeight);

    List<Bird> findBirdsByColor(String color);
    Bird findBirdByNest(Nest nest);

}
