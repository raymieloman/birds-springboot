package nl.youngcapital.birds.persistence;

import nl.youngcapital.birds.model.Egg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EggRepository extends JpaRepository<Egg, Long> {

}
