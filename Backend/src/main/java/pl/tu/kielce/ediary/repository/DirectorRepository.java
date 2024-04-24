package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Director;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    Director findDirectorByEmailAddress(String emailAddress);
}
