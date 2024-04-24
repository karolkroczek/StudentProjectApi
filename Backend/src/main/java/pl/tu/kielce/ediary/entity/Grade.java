package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "id_subject")
    private Subject subject;
    private int grade;
    private String addedDate;
    private String comment;
    private String type;

    public Grade(){}
    public Grade(Student student, Teacher teacher, Subject subject, int grade, String addedDate, String comment, String type) {
        this.student = student;
        this.teacher = teacher;
        this.subject = subject;
        this.grade = grade;
        this.addedDate = addedDate;
        this.comment = comment;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
