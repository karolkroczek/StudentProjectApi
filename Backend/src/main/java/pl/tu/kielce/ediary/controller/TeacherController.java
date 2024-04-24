package pl.tu.kielce.ediary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tu.kielce.ediary.entity.Teacher;
import pl.tu.kielce.ediary.entity.User;
import pl.tu.kielce.ediary.service.TeacherService;
import pl.tu.kielce.ediary.service.UserService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("teacher")
public class TeacherController {

    private final TeacherService teacherService;
    private final UserService userService;
    @Autowired
    public TeacherController(TeacherService teacherService,UserService userService){
        this.teacherService = teacherService;
        this.userService = userService;
    }


    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @PostMapping
    public void addTeacher(@RequestBody TeacherRequest teacher){
        System.out.println(teacher.getTeacherInfo());
        teacherService.addTeacher(teacher.getTeacherInfo());
        userService.addNewUser(new User(teacher.getTeacherInfo().getEmailAddress(),teacher.getPassword(),"Teacher"));
    }

    @DeleteMapping("/{id}")
    public void deleteTeacherById(@PathVariable long id){
        teacherService.deleteTeacherById(id);
    }

    @PutMapping("/{id}")
    public void updateTeacherById(@PathVariable long id, @RequestBody Teacher newTeacher){
        teacherService.updateTeacherById(id, newTeacher);
    }













}
