package pl.tu.kielce.ediary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tu.kielce.ediary.entity.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findByFrom(String emailAddress);
    Message findMessageByIdMessage(long messageId);
    List<Message> findByTo(String emailAddress);
}
