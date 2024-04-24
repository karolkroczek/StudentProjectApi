package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Frequency;

public interface FrequencyRepository extends JpaRepository<Frequency,Integer> {
}
