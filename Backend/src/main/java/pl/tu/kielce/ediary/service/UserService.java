package pl.tu.kielce.ediary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.User;
import pl.tu.kielce.ediary.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<String> getAllUserMails(){
        List<String> userEmails = new ArrayList<>();
        List<User> res = userRepository.findAll();
        for(User user : res){
            userEmails.add(user.getEmailAddress());
        }
        return userEmails;
    }
    public User getUserByEmailAddressAndPassword(String emailAddress , String password){
        System.out.println(emailAddress+":"+password);
        System.out.println(userRepository.findUserByEmailAddressAndPassword(emailAddress,password));
        return userRepository.findUserByEmailAddressAndPassword(emailAddress,password);
    }
    public void addNewUser(User user){
        userRepository.save(user);
    }
}
