package pl.tu.kielce.ediary.service;

import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.Grade;
import pl.tu.kielce.ediary.entity.Student;
import pl.tu.kielce.ediary.entity.Subject;
import pl.tu.kielce.ediary.entity.Teacher;
import pl.tu.kielce.ediary.repository.GradeRepository;

import java.util.List;

@Service
public class GradeService {

    public final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository){
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getAllGradesByStudentAndSubject(Student student, Subject subject){
        return gradeRepository.findByStudentAndSubject(student, subject);
    }

    public List<Grade> getAllGradesByStudent(Student student){
        return gradeRepository.findByStudent(student);
    }

    public List<Grade> getAllGradesByTeacher(Teacher teacher){
        return gradeRepository.findByTeacher(teacher);
    }



    public void addGrade(Grade grade){
        gradeRepository.save(grade);
    }

    public void deleteGrade(Grade grade){
        gradeRepository.delete(grade);
    }

    public void deleteGradeById(Long gradeId){
        gradeRepository.deleteById(gradeId);
    }

    public void updateGradeById(Long gradeId, Grade updatedGrade){
        gradeRepository.findById(gradeId).ifPresent(grade -> {
            grade.setGrade(updatedGrade.getGrade());
            grade.setStudent(updatedGrade.getStudent());
            grade.setComment(updatedGrade.getComment());
            grade.setSubject(updatedGrade.getSubject());
            grade.setType(updatedGrade.getType());
            grade.setTeacher(updatedGrade.getTeacher());
            grade.setAddedDate(updatedGrade.getAddedDate());

        });
    }












}
