package pl.tu.kielce.ediary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.tu.kielce.ediary.entity.SchoolClass;
import pl.tu.kielce.ediary.repository.ClassRepository;
import pl.tu.kielce.ediary.service.ClassService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/classes")
public class ClassController {

    public final ClassService classService;

    @Autowired
    public ClassController(ClassService classService){
        this.classService = classService;
    }

    @GetMapping
    public List<SchoolClass> getAllClass(){
        return classService.getAllClass();
    }

    @GetMapping("/{id}")
    public SchoolClass findClassById(@PathVariable int id){
        return classService.findById(id).orElse(null);
    }

    @PostMapping
    public void addClass(@RequestBody SchoolClass class_){
        classService.addClass(class_);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable int id){
        classService.deleteClass(id);
    }

}
