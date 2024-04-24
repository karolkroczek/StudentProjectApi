package pl.tu.kielce.ediary.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tu.kielce.ediary.entity.SchoolClass;
import pl.tu.kielce.ediary.entity.Teacher;
import pl.tu.kielce.ediary.repository.SchoolClassRepository;

import java.util.List;


@Service

public class SchoolClassService {


    private final SchoolClassRepository schoolClassRepository;

    @Autowired
    public SchoolClassService(SchoolClassRepository schoolClassRepository){
        this.schoolClassRepository = schoolClassRepository;
    }


    public void addClass(SchoolClass schoolClass){
        schoolClassRepository.save(schoolClass);
        System.out.println("A new school class has been successfully added");
    }

    public void deleteClassById(Long classId){
        schoolClassRepository.deleteById(classId);
        System.out.println("School class with id" + classId + " has been successfully deleted");
    }

    public List<SchoolClass> getAllClasses(){
        return schoolClassRepository.findAll();
    }

    public void getClassByTeacher(Teacher teacher){
        schoolClassRepository.findByTeacher(teacher);
    }

    public void updateSchoolClass(Long classId, SchoolClass newClass){
        schoolClassRepository.findById(classId).ifPresent(schoolClass -> {
            schoolClass.setName(newClass.getName());
            schoolClass.setTeacher(newClass.getTeacher());
            schoolClass.setFinishYear(newClass.getFinishYear());
            schoolClass.setStartYear(newClass.getStartYear());

        });
        System.out.println("SchoolClass has been successfully updated");
    }






}
