package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Grade;
import pl.tu.kielce.ediary.entity.Student;
import pl.tu.kielce.ediary.entity.Subject;
import pl.tu.kielce.ediary.entity.Teacher;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudentAndSubject(Student student, Subject subject);
    List<Grade> findByTeacher(Teacher teacher);

    List<Grade> findByStudent(Student student);
}
