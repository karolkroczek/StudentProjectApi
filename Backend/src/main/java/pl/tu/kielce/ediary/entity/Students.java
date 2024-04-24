package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;

import javax.lang.model.element.Name;
import java.util.List;

@Entity
@Table(name = "students")
public class Students {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStudent")
    private int idStudent;

    @Column(name = "idClass")
    private Integer idClass;
    @Column(name = "name")

    private String name;
    @Column(name = "surname")

    private String surname;
    @Column(name = "pesel")

    private String pesel;
    @Column(name = "address")

    private String address;
    @Column(name = "phoneNumber")
    private int phoneNumber;
//    @Column(name = "phoneNumberToParent")
//    private int phoneNumberToParent;
    @Column(name = "emailAddress")
    private String emailAddress;


    @Column(name = "listaOcen")
    @OneToMany(mappedBy = "idStudent")
    private List<Marks> Marks;

    @ManyToOne
    @JoinColumn(name = "listaObecnych")
    private Frequency listaObecnych;


    public Students() {
    }
    public Students(int idClass, String name, String surname, String pesel, String address, int phoneNumber, String emailAdress) {
        this.idClass = idClass;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAdress;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAddress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAdress() {
        return emailAddress;
    }

    public void setEmailAdress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
