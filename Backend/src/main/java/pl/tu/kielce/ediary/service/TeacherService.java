package pl.tu.kielce.ediary.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.Grade;
import pl.tu.kielce.ediary.entity.Student;
import pl.tu.kielce.ediary.entity.Teacher;
import pl.tu.kielce.ediary.repository.TeacherRepository;

import java.util.List;

@Service

public class TeacherService {
    @Autowired
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addGrade(Teacher teacher, Grade grade){
        teacher.addGrade(grade);
    }

    public Teacher getTeacherByEmailAddress(String emailAddress){
        return teacherRepository.findTeacherByEmailAddress(emailAddress);
    }
    public void addTeacher(Teacher teacher){
        List<Teacher> existingTeachers = getAllTeachers();

        boolean teacherExists = existingTeachers.stream()
                .anyMatch(existingTeacher -> existingTeacher.getPesel() == (teacher.getPesel()));

        if(teacherExists) {
            System.out.println("A teacher with this PESEL number already exists");
        }else{
            teacherRepository.save(teacher);
            System.out.println("A new teacher has been successfully added");
        }
    }

    public void deleteTeacherById(long id){
        teacherRepository.deleteById(id);
    }

    public void updateTeacherById(long id, Teacher newTeacher){
        teacherRepository.findById(id).ifPresent(teacher -> {
            teacher.setName(newTeacher.getName());
            teacher.setSurname(newTeacher.getSurname());
            teacher.setPesel(newTeacher.getPesel());
            teacher.setEmailAddress(newTeacher.getEmailAddress());
            teacher.setGrade(newTeacher.getGrade());
        });
    }









}
