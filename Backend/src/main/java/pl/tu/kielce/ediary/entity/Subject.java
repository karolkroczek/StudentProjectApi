package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "subjects",cascade=CascadeType.MERGE)
    private List<Teacher> teachers = new ArrayList<>();

    @OneToMany(mappedBy = "subject",cascade=CascadeType.MERGE)
    private List<Lesson> lessons;

    public void addTeacher(Teacher teacher){
        System.out.println("Dodano naucziela do przemiotu");
        teachers.add(teacher);
    }




    public Subject(){

    }

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
