package pl.tu.kielce.ediary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.DaySchedule;
import pl.tu.kielce.ediary.repository.DayScheduleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DayScheduleService {
    private final DayScheduleRepository dayScheduleRepository;

    @Autowired
    DayScheduleService(DayScheduleRepository dayScheduleRepository){
        this.dayScheduleRepository = dayScheduleRepository;
    }

    public Optional<DaySchedule> getDayScheduleById(int id){
        return dayScheduleRepository.findById(id);
    }
    public void addNewDaySchedule(DaySchedule daySchedule){
        dayScheduleRepository.save(daySchedule);
    }

    public void deleteDaySchedule(int id){
        dayScheduleRepository.deleteById(id);
    }


    public List<DaySchedule> getAllSchedules() {
        return dayScheduleRepository.findAll();
    }
}
