package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
}
