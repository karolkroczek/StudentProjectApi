package pl.tu.kielce.ediary.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tu.kielce.ediary.entity.Homework;

import java.util.List;


public interface HomeworkRepository extends JpaRepository<Homework, Integer> {

    List<Homework> findAllByIdClass(long id);
}
