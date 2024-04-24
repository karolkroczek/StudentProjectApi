package pl.tu.kielce.ediary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.tu.kielce.ediary.entity.Homework;
import pl.tu.kielce.ediary.service.HomeworkService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/homework")
public class HomeworkController {

    private final HomeworkService homeworkService;

    @Autowired
    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @GetMapping
    public List<Homework> getAllHomework() {
        return homeworkService.getAllHomework();
    }

    @GetMapping("/{id}")
    public List<Homework> getAllHomework(@PathVariable long id) {
        return homeworkService.getAllHomeworkByClassId(id);
    }

    @PostMapping
    public void addHomework(@RequestBody Homework homework) {
        homeworkService.addHomework(homework);
    }

    @DeleteMapping("/{id}")
    public void removeHomeworkById(@PathVariable int id) {
        homeworkService.removeHomeworkById(id);
    }
}
