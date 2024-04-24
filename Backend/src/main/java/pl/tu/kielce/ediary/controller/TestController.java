package pl.tu.kielce.ediary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tu.kielce.ediary.entity.Test;
import pl.tu.kielce.ediary.service.TestService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("tests")
public class TestController {
    private  final TestService testService;

    @Autowired
    TestController(TestService homeworksListService){
        this.testService =  homeworksListService;
    }

    @PostMapping()
    public void addTeacher(@RequestBody Test homeworksList){
        testService.addTestToList(homeworksList);
    }


    @GetMapping("{id}")
    List<Test> getAllTestsByClassId(@PathVariable Long id){
     return this.testService.getAllClassTests(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTestById(@PathVariable long id){
        testService.deleteTestById(id);
    }


}
