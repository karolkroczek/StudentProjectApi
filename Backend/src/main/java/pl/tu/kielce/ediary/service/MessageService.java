package pl.tu.kielce.ediary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.Message;
import pl.tu.kielce.ediary.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public void sendNewMessage(Message message){
            messageRepository.save(message);
    }

    public List<Message> getAllReceivedMessages(String emailAddress){
       return messageRepository.findByTo(emailAddress);
    }

    public Message getMessageById(long id){
        return messageRepository.findMessageByIdMessage(id);
    }

    public void deleteMessageById(Long id){
        messageRepository.deleteById(id);
    }

}
