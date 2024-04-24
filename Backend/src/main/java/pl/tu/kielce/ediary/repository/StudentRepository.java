package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentById(Long id);

    Student findStudentByEmailAddress(String emailAddress);
}
