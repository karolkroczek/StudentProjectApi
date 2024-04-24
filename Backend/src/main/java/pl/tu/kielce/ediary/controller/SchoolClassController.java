package pl.tu.kielce.ediary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tu.kielce.ediary.entity.SchoolClass;
import pl.tu.kielce.ediary.entity.Teacher;
import pl.tu.kielce.ediary.service.SchoolClassService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("SchoolClass")
public class SchoolClassController {

    @Autowired
    private final SchoolClassService schoolClassService;

    @Autowired
    public SchoolClassController(@RequestBody SchoolClassService schoolClassService){
        this.schoolClassService = schoolClassService;
    }
    @GetMapping("all")
    public List<SchoolClass> getAllClasses(){
        return schoolClassService.getAllClasses();
    }


    @GetMapping
    public void getClassByTeacher(@RequestBody Teacher teacher){
        schoolClassService.getClassByTeacher(teacher);
    }

    @PostMapping
    public void addClass(@RequestBody SchoolClass schoolClass){
        schoolClassService.addClass(schoolClass);
    }

    @DeleteMapping
    public void deleteClassById(@PathVariable Long classId){
        schoolClassService.deleteClassById(classId);
    }

    @PutMapping
    public void updateSchoolClass(@PathVariable Long classId, @RequestBody SchoolClass newClass){
        schoolClassService.updateSchoolClass(classId,newClass);
    }














}
