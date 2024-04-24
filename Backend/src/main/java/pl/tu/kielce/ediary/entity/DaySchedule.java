package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "daySchedules")
public class DaySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDaySchedule")
    private Long scheduleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Lekcja1")
    private Subject pierwszaLekcja;

    @ManyToOne
    @JoinColumn(name = "Lekcja2")
    private Subject drugaLekcja;



    @Override
    public String toString() {
        return "DaySchedule{" +
                "scheduleId=" + scheduleId +
                ", pierwszaLekcja=" + pierwszaLekcja +
                ", drugaLekcja=" + drugaLekcja +
                ", trzeciaLekcja=" + trzeciaLekcja +
                ", czwartaLekcja=" + czwartaLekcja +
                ", piataLekcja=" + piataLekcja +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "Lekcja3")
    private Subject trzeciaLekcja;

    @ManyToOne
    @JoinColumn(name = "Lekcja4")
    private Subject czwartaLekcja;


    @ManyToOne
    @JoinColumn(name = "Lekcja5")
    private Subject piataLekcja;

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Subject getPierwszaLekcja() {
        return pierwszaLekcja;
    }

    public void setPierwszaLekcja(Subject pierwszaLekcja) {
        this.pierwszaLekcja = pierwszaLekcja;
    }

    public Subject getDrugaLekcja() {
        return drugaLekcja;
    }

    public void setDrugaLekcja(Subject drugaLekcja) {
        this.drugaLekcja = drugaLekcja;
    }

    public Subject getTrzeciaLekcja() {
        return trzeciaLekcja;
    }

    public void setTrzeciaLekcja(Subject trzeciaLekcja) {
        this.trzeciaLekcja = trzeciaLekcja;
    }

    public Subject getCzwartaLekcja() {
        return czwartaLekcja;
    }

    public void setCzwartaLekcja(Subject czwartaLekcja) {
        this.czwartaLekcja = czwartaLekcja;
    }

    public Subject getPiataLekcja() {
        return piataLekcja;
    }

    public void setPiataLekcja(Subject piataLekcja) {
        this.piataLekcja = piataLekcja;
    }
}