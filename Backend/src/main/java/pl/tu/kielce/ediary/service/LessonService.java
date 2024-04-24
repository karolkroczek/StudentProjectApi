package pl.tu.kielce.ediary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.Lesson;
import pl.tu.kielce.ediary.entity.SchoolClass;
import pl.tu.kielce.ediary.entity.Teacher;
import pl.tu.kielce.ediary.repository.LessonRepository;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository){
        this.lessonRepository = lessonRepository;
    }

    public void addLesson(Lesson lesson){
        lessonRepository.save(lesson);
        System.out.println("A new lesson has been successfully added");
    }

    public void deleteLessonById(Long lessonId){
        lessonRepository.deleteById(lessonId);
        System.out.println("Lesson with id " + lessonId + " has been successfully delted");
    }

   public List<Lesson> getAllLessons(){
        return lessonRepository.findAll();
   }

   public List<Lesson> getAllLessonBySchoolClass(SchoolClass schoolClass){
        return  lessonRepository.findBySchoolClass(schoolClass);
   }

   public List<Lesson> getAllLessonByTeacher(Teacher teacher) {
       return lessonRepository.findByTeacher(teacher);
   }

   public void updateLessonById(Long lessonId, Lesson newLesson){
        lessonRepository.findById(lessonId).ifPresent(lesson -> {
            lesson.setSubject(newLesson.getSubject());
            lesson.setTeacher(newLesson.getTeacher());
            lesson.setClassRoomNumber(newLesson.getClassRoomNumber());
            lesson.setStartHour(newLesson.getStartHour());
            lesson.setFinishHour(newLesson.getFinishHour());
            lesson.setSchoolClass(newLesson.getSchoolClass());
        });
   }




}
