package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;
    private String birthDate;

    //Relacja z klasa


    //Relacja z Homework


    //Relacja z graduate
    @OneToMany(
            mappedBy = "student",
            fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE,
            orphanRemoval = true

    )
    private List<Grade> grades = new ArrayList<>();
    private String address;
    private String pesel;
    private int phoneNumber;
    private String emailAddress;
    private String parentName;
    private String parentSurname;
    private String paretEmailAddress;
    private int parentPhoneNumber;

    public Student(){

    }
    public Student(String name, String surname, String birthDate, String address, int phoneNumber, String emailAddress,String pesel, String parentName, String parentSurname, String paretEmailAddress, int parentPhoneNumber) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.parentName = parentName;
        this.parentSurname = parentSurname;
        this.paretEmailAddress = paretEmailAddress;
        this.parentPhoneNumber = parentPhoneNumber;
        this.pesel = pesel;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentSurname() {
        return parentSurname;
    }

    public void setParentSurname(String parentSurname) {
        this.parentSurname = parentSurname;
    }

    public String getParetEmailAddress() {
        return paretEmailAddress;
    }

    public void setParetEmailAddress(String paretEmailAddress) {
        this.paretEmailAddress = paretEmailAddress;
    }

    public int getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public void setParentPhoneNumber(int parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public List<Grade> getGrades() {
        return grades;
    }


    @Override
    public String toString() {
        return "Student{" +

                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", grades=" + grades +
                ", address='" + address + '\'' +
                ", pesel='" + pesel + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                ", parentName='" + parentName + '\'' +
                ", parentSurname='" + parentSurname + '\'' +
                ", paretEmailAddress='" + paretEmailAddress + '\'' +
                ", parentPhoneNumber=" + parentPhoneNumber +
                '}';
    }
}
