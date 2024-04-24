package pl.tu.kielce.ediary.controller;

import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tu.kielce.ediary.entity.Student;
import pl.tu.kielce.ediary.entity.User;
import pl.tu.kielce.ediary.service.StudentService;
import pl.tu.kielce.ediary.service.UserService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;
    private final UserService userService;
    @Autowired
    public StudentController(StudentService studentService,UserService userService){
        this.studentService = studentService;
        this.userService=userService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody StudentRequest student){
        System.out.println(student.getStudentInfo());
        studentService.addStudent(student.getStudentInfo());
        userService.addNewUser(new User(student.getStudentInfo().getEmailAddress(),student.getPassword(),"Student"));
        System.out.println("Dodano nowego ucznia");
    }
    @GetMapping("/{id}")
    public void updateStudentById(@PathVariable long id){
        studentService.getStudentById(id);
    }
    @PutMapping("/{id}")
    public void updateStudentById(@PathVariable long id, @RequestBody Student student){
        studentService.updateStudentById(id,student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable long id){
        studentService.deleteStudentById(id);
    }



}
