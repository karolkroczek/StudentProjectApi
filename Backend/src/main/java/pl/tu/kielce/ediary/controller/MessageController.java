package pl.tu.kielce.ediary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.tu.kielce.ediary.entity.Message;
import pl.tu.kielce.ediary.entity.Teacher;
import pl.tu.kielce.ediary.service.MessageService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("message")
public class MessageController {


    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public void getAllTeachers(@RequestBody Message message){
        System.out.println(message);
        messageService.sendNewMessage(message);
        System.out.println("Poprawnie wysłano wiadomosc");
    }

    @GetMapping
    public List<Message> getAllMessagesByEmail(@RequestParam String email){
        System.out.println(email);
        return messageService.getAllReceivedMessages(email);
    }

    @GetMapping("/message")
    public Message getMessage(@RequestParam long id){
        return messageService.getMessageById(id);
    }
}
