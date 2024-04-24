package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Lessons;

public interface LessonsRepository extends JpaRepository<Lessons,Integer> {
}
