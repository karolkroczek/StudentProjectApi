package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "*")
@Entity
@Table(name = "marks")
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMark")
    private int idMark;

    @Column(name = "mark")
    private int mark;

    public void setFinalmark(boolean finalmark) {
        Finalmark = finalmark;
    }

    @Getter
    @Column(name = "finalMark")
    private boolean Finalmark;
    @Column(name = "description")
    private String description;

//    @Column(name = "scale")
//    private int scale;


    @Column(name = "idStudent")
    private long idStudent;

    public Marks() {

    }

    public Marks(int idMark, int mark, boolean finalmark, String description) {
        this.idMark = idMark;
        this.mark = mark;
        Finalmark = finalmark;
        this.description = description;
    }

    public int getIdMark() {
        return idMark;
    }

    public void setIdMark(int idMark) {
        this.idMark = idMark;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinalmark() {
        return Finalmark;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }
}
