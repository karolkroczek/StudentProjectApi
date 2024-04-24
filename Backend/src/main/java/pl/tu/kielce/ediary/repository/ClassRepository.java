package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.SchoolClass;

public interface ClassRepository extends JpaRepository<SchoolClass, Integer> {

}
