package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "homework")
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHomework")
    private Integer idHomework;


    @Column(name = "idClass")
    private long idClass;

    @Column(name = "description")
    private String content;

    @Column(name = "date")
    private String date;

    public long getIdClass() {
        return idClass;
    }

    public void setIdClass(long idClass) {
        this.idClass = idClass;
    }

    public Homework(){

    }
    public Homework(Integer idHomework, Integer idClass, String content, String date) {
        this.idHomework = idHomework;


        this.content = content;
        this.date = date;
    }

    public Integer getIdHomework() {
        return idHomework;
    }

    public void setIdHomework(Integer idHomework) {
        this.idHomework = idHomework;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}



