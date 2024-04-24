package pl.tu.kielce.ediary.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.tu.kielce.ediary.entity.DaySchedule;
import pl.tu.kielce.ediary.entity.Schedule;
import pl.tu.kielce.ediary.service.ScheduleService;

import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

    @GetMapping("/{id}")
    public Optional<Schedule> getSchedule(@PathVariable int id){
        return scheduleService.getScheduleById(id);

    }
    @PostMapping()
    public String addNewSchedule(@RequestBody Schedule schedule){
        scheduleService.addSchedule(schedule);
        return "Utworzono nowy schedule";
    }
    @DeleteMapping("/{id}")
    public String deleteSchedule(@PathVariable int id){
        scheduleService.deleteSchedule(id);
        return "Usunieto schedule";
    }

}
