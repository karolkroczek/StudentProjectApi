package pl.tu.kielce.ediary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tu.kielce.ediary.entity.Subject;
import pl.tu.kielce.ediary.service.SubjectService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }


    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public void addSubject(@RequestBody Subject subject){
        subjectService.addSubject(subject);
    }

    @DeleteMapping("/{id}")
    public void deleteSubjectById(@PathVariable long id){
        subjectService.deleteSubjectById(id);
    }

    @PutMapping
    public void updateSubjectById(@PathVariable long id, String name, String desc){
        subjectService.updateSubjectById(id, name, desc);

    }









}
