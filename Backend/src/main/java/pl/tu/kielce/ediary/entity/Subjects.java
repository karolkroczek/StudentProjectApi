package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;

import java.util.List;

//Przedmioty
@Entity
@Table(name = "subjects")
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSubject")
    private int idSubject;

    @Column(name = "subjectName")
    private String subjectName;

    @ManyToMany(
            cascade = {CascadeType.MERGE,CascadeType.PERSIST}
    )
    @JoinTable(
            name = "subjects_teachers",
            joinColumns = @JoinColumn(name="idSubject"),
            inverseJoinColumns = @JoinColumn(name="idTeacher")
    )
    @Column(name = "idTeacher")
    private List<Teachers> teachers;


    public Subjects(int idSubject, String subjectName, int idTeacher) {
        this.idSubject = idSubject;
        this.subjectName = subjectName;
    }


    public Subjects() {

    }

    public void addTracher(Teachers teacher){
        this.teachers.add(teacher);
        teacher.getSubjects().add(this);
    }

    public void removeTeacher(Teachers teacher){
        this.teachers.remove(teacher);
        teacher.getSubjects().remove(this);
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

}
