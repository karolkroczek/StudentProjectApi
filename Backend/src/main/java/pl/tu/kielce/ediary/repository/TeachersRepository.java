package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Teachers;

public interface TeachersRepository extends JpaRepository<Teachers,Integer> {
}
