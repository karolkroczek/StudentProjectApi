package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Test;

import java.util.List;

public interface TestRepository extends JpaRepository<Test,Long> {
    List<Test> findAllByClassId_Id(Long classId);
}
