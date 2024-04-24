package pl.tu.kielce.ediary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.tu.kielce.ediary.entity.Grade;
import pl.tu.kielce.ediary.entity.Student;
import pl.tu.kielce.ediary.entity.Subject;
import pl.tu.kielce.ediary.repository.GradeRepository;
import pl.tu.kielce.ediary.service.GradeService;

import java.util.List;

@RestController
@RequestMapping("grade")
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService){
        this.gradeService = gradeService;
    }



    @GetMapping("/by-student-and-subject")
    public List<Grade> getAllGradesByStudentAndSubject(@RequestBody Student student, @RequestBody Subject subject){
        return gradeService.getAllGradesByStudentAndSubject(student,subject);
    }

    @GetMapping("/student-grades")
    public List<Grade> getAllGGradesByStudent(@RequestBody Student student){
        return gradeService.getAllGradesByStudent(student);
    }

    @PostMapping
    public void addGrade(@RequestBody Grade grade){
        gradeService.addGrade(grade);
    }

    @DeleteMapping({"/id"})
    public void deleteGradeById(@PathVariable Long id){
        gradeService.deleteGradeById(id);
    }

    @DeleteMapping
    public void deleteGrade(Grade grade){
        gradeService.deleteGrade(grade);
    }

    @PutMapping
    public void updateGradeById(@PathVariable Long id, @RequestBody Grade grade){
        gradeService.updateGradeById(id, grade);
    }








}
