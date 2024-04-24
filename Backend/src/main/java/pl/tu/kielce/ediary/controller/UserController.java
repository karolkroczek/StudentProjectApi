package pl.tu.kielce.ediary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tu.kielce.ediary.entity.User;
import pl.tu.kielce.ediary.service.DirectorService;
import pl.tu.kielce.ediary.service.StudentService;
import pl.tu.kielce.ediary.service.TeacherService;
import pl.tu.kielce.ediary.service.UserService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("users")
public class UserController {
    UserService userService;
    StudentService studentService;
    DirectorService directorService;
    TeacherService teacherService;
    @Autowired
    UserController(    UserService userService,
    StudentService studentService,
    DirectorService directorService,
    TeacherService teacherService){
        this.userService = userService;
        this.directorService = directorService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @GetMapping("mails")
    List<String> getUsersMails(){
        return userService.getAllUserMails();
    }

    @PostMapping()
    Object getUserByUsernameAndPassword(@RequestBody User formDetails){

        User res = userService.getUserByEmailAddressAndPassword(formDetails.getEmailAddress(), formDetails.getPassword());
        System.out.println(res);
         switch (res.getRole()) {
            case "Student" :
               return new StudentResponse(studentService.getStudentByEmailAddress(res.getEmailAddress()),"Student");
            case "Teacher" :
                return new TeacherResponse(teacherService.getTeacherByEmailAddress(res.getEmailAddress()),"Teacher");
            case "Director" :
               return new DirectorResponse(directorService.getDirectorByEmailAddress(res.getEmailAddress()),"Director");

            default:
                throw new IllegalStateException("Unexpected value: " + res.getRole());
         }

    }
}
