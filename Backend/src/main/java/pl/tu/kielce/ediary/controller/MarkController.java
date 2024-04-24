package pl.tu.kielce.ediary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tu.kielce.ediary.entity.Marks;
import pl.tu.kielce.ediary.service.MarkService;
import pl.tu.kielce.ediary.service.StudentService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/marks")
public class MarkController {
    private final MarkService markService;
    private final StudentService studentService;


    @Autowired
    MarkController(MarkService markService, StudentService studentService){

        this.markService = markService;
        this.studentService = studentService;
    }

    @GetMapping("mark/{id}")
    public Marks getMarkById(@PathVariable int id){
        return markService.getMarksById(id).orElse(null);
    }

    @GetMapping("student/{id}")
    public List<Marks> getMarkById(@PathVariable long id){
        return markService.getMarksByStudentId(id);
    }

    @PostMapping()
    public String addNewMark(@RequestBody Marks mark){
            markService.addNewMark(mark);
            return "";
    }

    @DeleteMapping("/{id}")
    public String deleteMark(@PathVariable int id){
        markService.deleteMark(id);
        return "Usunieto ocene";
    }

}
