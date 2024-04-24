package pl.tu.kielce.ediary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tu.kielce.ediary.entity.Lesson;
import pl.tu.kielce.ediary.entity.Teacher;
import pl.tu.kielce.ediary.service.LessonService;

import java.util.List;

@RestController
@RequestMapping("lesson")
public class LessonController {

    @Autowired
    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService){
        this.lessonService = lessonService;
    }

    @GetMapping
    public List<Lesson> getAllLessonByTeacher(Teacher teacher){
        return lessonService.getAllLessonByTeacher(teacher);
    }

    @PostMapping
    public void addLesson(Lesson lesson){
        lessonService.addLesson(lesson);
    }



}
