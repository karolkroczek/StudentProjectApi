package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "idTests")
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private String date;

    @ManyToOne()
    @JoinColumn(name = "classId")
    private SchoolClass classId;

    @ManyToOne()
    @JoinColumn(name = "teacherId")
    private Teacher teacherId;

    public Test(){

    }
    public Test(long id, String desctiption, String date, SchoolClass classId) {
        this.id = id;
        this.description = desctiption;
        this.date = date;
        this.classId = classId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SchoolClass getClassId() {
        return classId;
    }

    public void setClassId(SchoolClass classId) {
        this.classId = classId;
    }
}
