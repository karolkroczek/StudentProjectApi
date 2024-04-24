package pl.tu.kielce.ediary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lessons")
public class Lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLesson")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idDaySchedule")
    private DaySchedule daySchedule;



}

