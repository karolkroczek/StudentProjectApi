package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Subjects;

public interface SubjectsRepository extends JpaRepository<Subjects,Integer> {
}
