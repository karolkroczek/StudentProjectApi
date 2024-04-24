package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //Relacja z Subject
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "id_subject")
    private Subject subject;

    //Relacja z Teacher
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    //Relacja z SchoolClass
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "id_schoolClass")
    private SchoolClass schoolClass;

    private int classRoomNumber;
    private String startHour;
    private String finishHour;

    public Lesson(){

    }
    public Lesson(Subject subject, Teacher teacher, SchoolClass schoolClass, int classRoomNumber, String startHour, String finishHour) {
        this.subject = subject;
        this.teacher = teacher;
        this.schoolClass = schoolClass;
        this.classRoomNumber = classRoomNumber;
        this.startHour = startHour;
        this.finishHour = finishHour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public int getClassRoomNumber() {
        return classRoomNumber;
    }

    public void setClassRoomNumber(int classRoomNumber) {
        this.classRoomNumber = classRoomNumber;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(String finishHour) {
        this.finishHour = finishHour;
    }
}
