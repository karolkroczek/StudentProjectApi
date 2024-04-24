package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    //Relacja z lesson

    @OneToMany(mappedBy = "schoolClass",cascade=CascadeType.MERGE)
    private List<Lesson> lessons;

    private int startYear;
    private int finishYear;

    public SchoolClass(){

    }

    public SchoolClass(String name, Teacher teacher, int startYear, int finishYear) {
        this.name = name;
        this.teacher = teacher;
        this.startYear = startYear;
        this.finishYear = finishYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getFinishYear() {
        return finishYear;
    }

    public void setFinishYear(int finishYear) {
        this.finishYear = finishYear;
    }
}

