package pl.tu.kielce.ediary.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tu.kielce.ediary.entity.Director;
import pl.tu.kielce.ediary.entity.User;
import pl.tu.kielce.ediary.service.DirectorService;
import pl.tu.kielce.ediary.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("director")
@AllArgsConstructor
public class DirectorController {
    @Autowired
    private final DirectorService directorService;
    private final UserService userService;

    @PostMapping()
    public void addNewDirector(@RequestBody DirectorRequest director){
        System.out.println(director.getDirectorInfo().getName());
        Boolean res = directorService.addDirector(director.getDirectorInfo());
        if(res){
            userService.addNewUser(new User(director.getDirectorInfo().getEmailAddress(),director.getPassword(),"Director"));
        }
    }

}
