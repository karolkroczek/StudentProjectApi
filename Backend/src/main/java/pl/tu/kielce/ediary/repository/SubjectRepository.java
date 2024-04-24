package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
