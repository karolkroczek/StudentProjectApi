package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findTeacherByEmailAddress(String emailAddress);
}
