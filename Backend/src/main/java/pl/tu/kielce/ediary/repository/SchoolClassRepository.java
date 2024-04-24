package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.SchoolClass;
import pl.tu.kielce.ediary.entity.Teacher;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
    void findByTeacher(Teacher teacher);


}
