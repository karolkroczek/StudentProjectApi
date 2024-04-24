package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.DaySchedule;

public interface DayScheduleRepository extends JpaRepository<DaySchedule,Integer> {
}
