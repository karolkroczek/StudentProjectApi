package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Lesson;
import pl.tu.kielce.ediary.entity.SchoolClass;
import pl.tu.kielce.ediary.entity.Teacher;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findBySchoolClass(SchoolClass schoolClass);
    List<Lesson> findByTeacher(Teacher teacher);
}
