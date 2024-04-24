package pl.tu.kielce.ediary.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.tu.kielce.ediary.entity.DaySchedule;
import pl.tu.kielce.ediary.service.DayScheduleService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/daySchedule")
public class DayScheduleController {
    public final DayScheduleService dayScheduleService;

    DayScheduleController(DayScheduleService dayScheduleService){
        this.dayScheduleService = dayScheduleService;
    }
    @GetMapping
    public List<DaySchedule> getAllDaySchedules(){
       return   dayScheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public Optional<DaySchedule> getDayScheduleById(@PathVariable int id){
        return dayScheduleService.getDayScheduleById(id);
    }
    @PostMapping()
    public String addDaySchedule(@RequestBody DaySchedule daySchedule){
        dayScheduleService.addNewDaySchedule(daySchedule);
        return "Dodano nowe daySchedule";
    }
    @DeleteMapping("/{id}")
    public String deleteDaySchedule(@PathVariable int id){
        dayScheduleService.deleteDaySchedule(id);
        return "Usunieto daySchedule o id: "+id;
    }
}
