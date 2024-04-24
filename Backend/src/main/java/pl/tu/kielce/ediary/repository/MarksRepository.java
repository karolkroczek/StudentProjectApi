package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Marks;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks,Integer> {
    List<Marks> findAllByIdStudent(long id);
}
