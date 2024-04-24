package pl.tu.kielce.ediary.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSchedule")
    private Long scheduleId;

    @ManyToOne()
    @JoinColumn(name = "Poniedzialek")
    private DaySchedule poniedzialek;

    @ManyToOne
    @JoinColumn(name = "Wtorek")
    private DaySchedule wtorek;

    @ManyToOne
    @JoinColumn(name = "Środa")
    private DaySchedule sroda;

    @ManyToOne
    @JoinColumn(name = "Czwartek")
    private DaySchedule czwartek;


    @ManyToOne()
    @JoinColumn(name = "Piątek")
    private DaySchedule piatek;

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public DaySchedule getPoniedzialek() {
        return poniedzialek;
    }

    public void setPoniedzialek(DaySchedule poniedzialek) {
        this.poniedzialek = poniedzialek;
    }

    public DaySchedule getWtorek() {
        return wtorek;
    }

    public void setWtorek(DaySchedule wtorek) {
        this.wtorek = wtorek;
    }

    public DaySchedule getSroda() {
        return sroda;
    }

    public void setSroda(DaySchedule sroda) {
        this.sroda = sroda;
    }

    public DaySchedule getCzwartek() {
        return czwartek;
    }

    public void setCzwartek(DaySchedule czwartek) {
        this.czwartek = czwartek;
    }

    public DaySchedule getPiatek() {
        return piatek;
    }

    public void setPiatek(DaySchedule piatek) {
        this.piatek = piatek;
    }
}
