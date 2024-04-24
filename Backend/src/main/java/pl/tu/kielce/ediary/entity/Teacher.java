package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;

    private int pesel;

    @Override
    public String toString() {
        return "Teacher{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel=" + pesel +
                ", grade='" + grade + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", subjects=" + subjects +
                ", grades=" + grades +
                ", schoolClass=" + schoolClass +
                ", lessons=" + lessons +
                '}';
    }

    private String grade;

    private String emailAddress;
    private int phoneNumber;

    //Relacja z Subject
    @ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
    @JoinTable(
            name="teacher_subject",
            joinColumns = @JoinColumn(name = "id_teacher"),
            inverseJoinColumns = @JoinColumn(name = "id_subject")
    )
    private List<Subject> subjects = new ArrayList<>();

    //Relacja z Grade

    @OneToMany(mappedBy = "teacher")
    private List<Grade> grades = new ArrayList<>();


    //Relacja z schoolClass
    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
    private SchoolClass schoolClass;

    @OneToMany(mappedBy = "teacher",cascade=CascadeType.ALL)
    private List<Lesson> lessons;


    public Teacher(){

    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }
    public void addGrade(Grade grade){
        grades.add(grade);
    }



    public Teacher(String name, String surname,int pesel, String grade, String emailAddress, int phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.pesel = pesel;

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
