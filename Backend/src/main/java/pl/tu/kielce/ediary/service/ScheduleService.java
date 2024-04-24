package pl.tu.kielce.ediary.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.Schedule;
import pl.tu.kielce.ediary.repository.ScheduleRepository;

import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository =  scheduleRepository;
    }

    public void addSchedule(Schedule schedule){
        scheduleRepository.save(schedule);
    }

    public Optional<Schedule> getScheduleById(int id)
    {
        return scheduleRepository.findById(id);
    }

    public void deleteSchedule(int id){
        scheduleRepository.deleteById(id);
    }

}
