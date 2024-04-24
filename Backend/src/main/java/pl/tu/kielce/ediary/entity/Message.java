package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMessage")
    private Long idMessage;

    @Column(name = "tittle")
    String tittle;

    @Column(name = "content")
    String content;

    @Column(name = "fromEmailAddress")
    String from;
    @Column(name = "toEmailAddress")
    String to;

    public Message(){

    }
    public Message(Long idMessage, String tittle, String content, String from, String to) {
        this.idMessage = idMessage;
        this.tittle = tittle;
        this.content = content;
        this.from = from;
        this.to = to;
    }

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Message{" +
                "idMessage=" + idMessage +
                ", tittle='" + tittle + '\'' +
                ", content='" + content + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
