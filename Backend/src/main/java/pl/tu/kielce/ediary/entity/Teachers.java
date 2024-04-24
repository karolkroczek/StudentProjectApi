package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;

import pl.tu.kielce.ediary.entity.Subjects;


import java.util.List;

@Entity
@Table(name ="teachers")
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTeacher")
    private int idTeacher;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "degree")
    private String degree;

    @OneToOne()
    @JoinColumn(name = "schedule")
    Schedule schedule;

    @ManyToMany(mappedBy = "teachers")
    @Column(name = "subjects")
    private List<Subjects> subjects;


    @ManyToMany(
            cascade = {CascadeType.MERGE,CascadeType.PERSIST}
    )
    @JoinTable(
            name = "teachers_classes",
            joinColumns = @JoinColumn(name = "idTeacher"),
            inverseJoinColumns = @JoinColumn(name = "idClass")
    )
    private List<SchoolClass> classes;


    public Teachers(){

    }
    public Teachers(int idTeacher, String name, String surname, String degree, Schedule schedule, List<Subjects> subjects, List<SchoolClass> classes, String email, String phoneNumber, int[] classList) {
        this.idTeacher = idTeacher;
        this.name = name;
        this.surname = surname;
        this.degree = degree;
        this.schedule = schedule;
        this.subjects = subjects;
        this.classes = classes;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.classList = classList;
    }

    public void addClass(SchoolClass schoolClass){
        this.classes.add(schoolClass);
//        schoolClass.getTeachersList().add(this);
    }

    public void removeClass(SchoolClass schoolClass){
        this.classes.remove(schoolClass);
//        schoolClass.getTeachersList().remove(this);
    }


    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

    @Column(name = "emailAddress")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name="classList")
    private int[] classList;

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdStudent(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
